package util

 class DebugLogger  constructor(tagString : String) {
     val tag = tagString
     fun log(message: String) {
        println("$tag: $message")
    }
}
