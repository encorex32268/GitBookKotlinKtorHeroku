import io.ktor.application.call
import io.ktor.html.respondHtml
import io.ktor.response.respond
import io.ktor.routing.get
import io.ktor.routing.route
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import kotlinx.html.body
import kotlinx.html.h1
import kotlinx.html.head
import kotlinx.html.title

fun main() {
    val port = System.getenv("PORT")?.toInt() ?: 8080
    val server = embeddedServer(Netty,port){
        routing {
            route("/"){
                get{
                    call.respondHtml {
                        head {
                            title {
                                text("Ktor web")
                            }
                        }
                        body {
                            h1 {
                                text("Hello Ktor")
                            }
                        }
                    }
                }
            }
        }
    }
    server.start(wait = true)


}