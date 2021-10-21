package example.micronaut.model

import io.micronaut.core.annotation.Introspected

@Introspected
data class GithubRelease(val name: String, val url: String)
