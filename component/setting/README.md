Common Setting 

all in DEF

DEF.config()...
DEF.setting()...
DEF.float()...

# 规范

1. 持久化只存相对路径

# 分区数据管理

分类规范：按文件类型分+按用途分

# 按文件类型分

业务场景：分享给其他App，用户的收藏癖好
应用场景：图片 音乐 视频等分类，按 Android 官方即可

规则：全部写到共享目录里
PICTURE/timecat/
VIDEO/timecat/

# 按用途分

业务场景：应用私有数据，用户私人数据，如设置、偏好、密钥、插件、皮肤、缓存等。
应用场景：偏好设置、用户自定义头图，自定义提示音，自定义字体，自定义背景，自定义皮肤，自定义插件

规则：全部写到私有目录里

第一级文件夹应该是用于运行时的，动态的，可随时被删除的。
cache
    Image 图片缓存
    Video 视频缓存
repo 用于数据同步的仓库（同步完可以被随时删除？TODO）
    仓库1
    仓库2
backup
    version.json
plugin 简单的插件，动态的插件，经常修改变动的插件
    插件1
    插件2
skin
    皮肤1
    皮肤2
shell 用于命令行
    usr
    home
    ...
system 用于存储业务数据


同步和备份要分开
备份是基于文件的。
同步属于备份，比备份的要求更高，有复杂的数据结构和代码实现，在基于文件这一点上和备份兼容。

# 用于同步的数据仓库的文件组织规范

README.md 说明文件
doc 进一步的说明文档
    changelog.md
    issue_template.md
files 资源文件夹
    Music 音乐
    Ringtone 提示音
    Record 录音
    Markdown MD文件
    Org Org文件
    Block 块文件
    MindMap 思维导图文件
    Plugin 插件文件 这里仅保存描述。业务具体的插件执行文件可能很大，需要下载到第一级文件夹
    Graft 嫁接文件（？待实现，本质是指针，将其他平台的资源嫁接到这里）
    Novel 小说文件
    Book 书文件
    Comic 漫画文件
    Subscribe 订阅文件
    NovelSource 小说书源管理文件
    Database 数据库符文对应的数据库文件
    ...
    扁平化管理，即文件夹下不应再建子文件夹。
    一个mp3文件就是一个mp3文件，其用途应该由所在的文件夹或外部其他文件定义的用途来决定。
    所在的文件夹并不能完全说明其用途。
    业务可以自定义用途，然后使用文件夹里的文件。
    文件夹名仅供开发者和对具体资源感兴趣对人提供参考，但不是绝对的。
.timecat
    时光猫用于管理的文件夹，定义了设置、偏好、数据、历史等。
    顶层需要规范接口，在底层可以用 MMKV 或者 SharePreference 实现。
    config.json 用户对此数据仓库的设置、偏好
    timecat_room.db 符文数据：标签 收藏 书签 记录








