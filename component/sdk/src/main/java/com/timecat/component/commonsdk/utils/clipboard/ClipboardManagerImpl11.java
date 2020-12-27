package com.timecat.component.commonsdk.utils.clipboard;

import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Build;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public final class ClipboardManagerImpl11 extends ClipboardManagerCompat {

    ClipboardManager.OnPrimaryClipChangedListener mOnPrimaryClipChangedListener = new ClipboardManager.OnPrimaryClipChangedListener() {
        @Override
        public void onPrimaryClipChanged() {
            notifyPrimaryClipChanged();
        }
    };
    private ClipboardManager mClipboardManager;

    public ClipboardManagerImpl11(Context context) {
        mClipboardManager = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
    }

    @Override
    public void addPrimaryClipChangedListener(OnPrimaryClipChangedListener listener) {
        super.addPrimaryClipChangedListener(listener);
        synchronized (mPrimaryClipChangedListeners) {
            if (mPrimaryClipChangedListeners.size() == 1) {
                mClipboardManager.removePrimaryClipChangedListener(mOnPrimaryClipChangedListener);
                mClipboardManager.addPrimaryClipChangedListener(mOnPrimaryClipChangedListener);
            }
        }
    }

    @Override
    public void removePrimaryClipChangedListener(OnPrimaryClipChangedListener listener) {
        super.removePrimaryClipChangedListener(listener);
        synchronized (mPrimaryClipChangedListeners) {
            if (mPrimaryClipChangedListeners.size() == 0) {
                mClipboardManager.removePrimaryClipChangedListener(mOnPrimaryClipChangedListener);
            }
        }
    }

    @Override
    public CharSequence getText() {
        if (mClipboardManager != null) {
            ClipData c = mClipboardManager.getPrimaryClip();
            if (c == null) return "";
            if (c.getItemCount() <= 0) return "";
            ClipData.Item item = c.getItemAt(0);
            if (item == null) return "";
            return item.getText();
        }
        return "";
    }
}
