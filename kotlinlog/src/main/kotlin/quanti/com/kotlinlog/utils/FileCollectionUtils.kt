package quanti.com.kotlinlog.utils

import java.io.File
import java.util.*

/**
 * Array section
 *
 * All array methods are just wrapper of toList and calling appropriate list method
 */

/**
 * Delete all files that are older than specified number of days inclusive
 */
fun Array<File>.deleteAllOldFiles(maxDaysOld: Int) = toList().deleteAllOldFiles(maxDaysOld)

/**
 * Delete all zip files
 */
fun Array<File>.deleteAllZips() = toList().deleteAllZips()

/**
 * Delete all files that matches given predicate
 */
fun Array<File>.deleteAll(filter: (File) -> Boolean) = toList().deleteAll(filter)

/**
 * Delete all files in current list
 */
fun Array<File>.deleteAll() = toList().deleteAll()

/**
 * Sort by age
 * Youngest file is on the beginning
 * Oldest file is on the end
 *
 * @param youngestFirst default behavior as explained in method documentation, reverses the list when false
 */
fun Array<File>.sortByAge(youngestFirst: Boolean = true) = toList().sortByAge(youngestFirst)


/**
 * List section
 */

/**
 * Delete all files that are older than specified number of days inclusive
 */
fun List<File>.deleteAllOldFiles(maxDaysOld: Int) = deleteAll { it.fileAge() > maxDaysOld }

/**
 * Delete all zip files
 */
fun List<File>.deleteAllZips() = deleteAll { it.name.contains(".zip") }

/**
 * Delete all files that matches given filter predicate
 */
fun List<File>.deleteAll(filter: (File) -> Boolean) {
    this.filter(filter)
            .forEach {
                val del = it.delete()
                loga("File deleted: " + del + "/t" + it.absolutePath)
            }
}

/**
 * Delete all files in current list
 */
fun List<File>.deleteAll() = deleteAll { true }


/**
 * Sort by age
 * Youngest file is on the beginning
 * Oldest file is on the end
 *
 * @param youngestFirst default behavior as explained in method documentation, reverses the list when false
 */
fun List<File>.sortByAge(youngestFirst: Boolean = true): List<File> {
    return if (youngestFirst){
        sortedWith(comparator)
    } else {
        sortedWith(comparator).reversed()
    }
}


private val comparator = Comparator<File> { o1, o2 ->
    val firstTime = o1.lastModified()
    val secondTime = o2.lastModified()

    return@Comparator (secondTime - firstTime).toInt()
}
