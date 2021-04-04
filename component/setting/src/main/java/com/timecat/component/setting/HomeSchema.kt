package com.timecat.component.setting

import android.net.Uri
import java.io.File

/**
 * @author 林学渊
 * @email linxy59@mail2.sysu.edu.cn
 * @date 2021/4/4
 * @description HomeSchema
 * 依赖关系 HomeSchema <- RepoSchema <- PATH <- DIR,FILE
 * @usage null
 */
object HomeSchema {

    /**
     * 随机生成的临时文件
     *
     * /storage/emulated/0/Android/data/<PackageName>/files/Temp/uuid.tmp
     */
    fun randomTemp(): Uri {
        return PATH.overOf(dir = DIR.Temp, filename = "${PATH.random()}$TempSuffix")
    }

    /**
     * 随机生成的数据库文件
     *
     * /storage/emulated/0/Android/data/<PackageName>/files/Database/uuid.timecat_db
     */
    fun randomDb(uuid: String = PATH.random()): Uri {
        return PATH.overOf(filename = RepoSchema.relativeRandomDb(uuid))
    }

    const val TempSuffix = ".tmp"

}