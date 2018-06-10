import spark.kotlin.*
import java.lang.Class

fun main(args: Array<String>) {
    val http: Http = ignite()

    http.get("/hello") {
        val handler = Class.forName("com.serverless.Handler")
        val instance = handler.newInstance()
        val method = handler.getMethod("foo")
        method.invoke(instance)
    }
}