package com.timecat.component.setting

/**
 * @author 林学渊
 * @email linxy59@mail2.sysu.edu.cn
 * @date 2021/4/4
 * @description 时光猫标准文件
 * @usage null
 */
enum class FILE(val fileName: String, val descName: String) {
    README("README.md", "说明"),
    RoomDatabase("timecat_room.db", "时光猫符文数据库"),


    ;

    override fun toString(): String {
        return fileName
    }
}