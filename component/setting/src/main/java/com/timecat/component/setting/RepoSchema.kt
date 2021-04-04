package com.timecat.component.setting

import java.io.File

/**
 * @author 林学渊
 * @email linxy59@mail2.sysu.edu.cn
 * @date 2021/4/4
 * @description RepoSchema
 * 依赖关系 RepoSchema <- PATH <- DIR,FILE
 * @usage null
 */
object RepoSchema {

    /**
     * 随机生成的数据库文件
     *
     * ./Database/uuid.timecat_db
     */
    fun relativeRandomDb(uuid: String = PATH.random()): String {
        return PATH.of(dir = DIR.Database, filename = "$uuid$RecordDBPathSuffix")
    }

    const val RecordDBPathSuffix = ".timecat_db"

    interface Listener {
        fun onSuccess()
        fun onFail()
    }

    fun check(repoDir: File, listener: Listener) {
        val roomDatabaseDir = File(repoDir, DIR.timecat.dirName)

        if (!roomDatabaseDir.isDirectory) {
            listener.onFail()
            return
        }
        val roomDatabaseFile = File(roomDatabaseDir, FILE.RoomDatabase.fileName)
        if (!roomDatabaseFile.isFile) {
            listener.onFail()
            return
        }
        listener.onSuccess()
    }

}