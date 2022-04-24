package util



import GlobalConfiguration.waitingTaskDirectory
import GlobalConfiguration.zipExtension

import java.io.File
import java.util.concurrent.TimeUnit


object Zip {

    fun Extract(inputPath: String, outputPath: String, passwrod: String = ""){
        val cmd ="""
            "${File(System.getProperty("compose.application.resources.dir"))}\7z2107x64\7z.exe" x
            "${inputPath}" -o${outputPath} -p${passwrod} -ao
        """.trimIndent()
        /* return runCommand(cmd)*/
        Runtime.getRuntime().exec(cmd).inputStream.bufferedReader().readText()
    }

    /**
     * 调用系统命令行中的命令.以List<String>的方式输入命令的各个参数.
     * 命令执行完毕后会以String?传回结果,不会在终端显示
     * 默认在当前目录中执行,超时时间为60秒
     */
    fun runCommand(
        cmd: String,
        workingDir: File = File("."),
        timeoutAmount: Long = 60L,
        timeUnit: TimeUnit = TimeUnit.SECONDS
    ): String? = runCatching {
        ProcessBuilder(cmd)
            .directory(workingDir)
            .redirectErrorStream(true)
            .start().also { it.waitFor(timeoutAmount, timeUnit) }
// jdk17之后这样写
//            .inputReader().readText()
// jdk17之前这样写
            .inputStream.bufferedReader().readText()
    }.onFailure { it.printStackTrace() }.getOrNull()?.ziplog()
    fun getfile(){

    }

}
