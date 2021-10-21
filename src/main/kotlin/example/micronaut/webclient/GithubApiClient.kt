package example.micronaut.webclient

import example.micronaut.configuration.GithubConfiguration
import example.micronaut.model.GithubRelease
import io.micronaut.http.HttpHeaders
import io.micronaut.http.HttpHeaders.ACCEPT
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Header
import io.micronaut.http.annotation.Headers
import io.micronaut.http.client.annotation.Client
import org.reactivestreams.Publisher

@Client(GithubConfiguration.GITHUB_API_URL)
@Headers(
        Header(name = HttpHeaders.USER_AGENT, value = "Micronaut HTTP Client"),
        Header(name = ACCEPT, value = "application/vnd.github.v3+json, application/json")
)
interface GithubApiClient {
    @Get("/repos/\${github.organization}/\${github.repo}/releases")
    fun fetchReleases(): Publisher<GithubRelease?>?
}