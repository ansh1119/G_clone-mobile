package org.gym.gclone

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform