package com.mehdisekoba.wallpaper.data.model.splash

import com.google.gson.annotations.SerializedName

class ResponsePhotos : ArrayList<ResponsePhotos.ResponsePhotosItem>() {
    data class ResponsePhotosItem(
        @SerializedName("alt_description")
        val altDescription: String?, // a woman scubas over a colorful coral reef
        @SerializedName("blur_hash")
        val blurHash: String?, // LzE:*@X.R-ai?wjZRQaf-:s8WWX8
        @SerializedName("breadcrumbs")
        val breadcrumbs: List<Any?>?,
        @SerializedName("color")
        val color: String?, // #0c8cc0
        @SerializedName("created_at")
        val createdAt: String?, // 2023-04-28T13:21:00Z
        @SerializedName("current_user_collections")
        val currentUserCollections: List<Any?>?,
        @SerializedName("description")
        val description: String?, // Home to kaleidoscopic-colored coral reefs and an abundance of diverse marine life | Islands of NEOM- NEOM, Saudi Arabia.
        @SerializedName("height")
        val height: Int?, // 4937
        @SerializedName("id")
        val id: String?, // jTxhUMyPTrE
        @SerializedName("liked_by_user")
        val likedByUser: Boolean?, // false
        @SerializedName("likes")
        val likes: Int?, // 147
        @SerializedName("links")
        val links: Links?,
        @SerializedName("promoted_at")
        val promotedAt: String?, // 2023-10-28T19:08:01Z
        @SerializedName("slug")
        val slug: String?, // a-woman-scubas-over-a-colorful-coral-reef-jTxhUMyPTrE
        @SerializedName("sponsorship")
        val sponsorship: Sponsorship?,
        @SerializedName("topic_submissions")
        val topicSubmissions: TopicSubmissions?,
        @SerializedName("updated_at")
        val updatedAt: String?, // 2023-10-27T22:33:55Z
        @SerializedName("urls")
        val urls: Urls?,
        @SerializedName("user")
        val user: User?,
        @SerializedName("width")
        val width: Int?, // 7406
    ) {
        data class Links(
            @SerializedName("download")
            val download: String?, // https://unsplash.com/photos/jTxhUMyPTrE/download?ixid=M3w1MTk4Njh8MXwxfGFsbHwxfHx8fHx8Mnx8MTY5ODUyMDE4MHw
            @SerializedName("download_location")
            val downloadLocation: String?, // https://api.unsplash.com/photos/jTxhUMyPTrE/download?ixid=M3w1MTk4Njh8MXwxfGFsbHwxfHx8fHx8Mnx8MTY5ODUyMDE4MHw
            @SerializedName("html")
            val html: String?, // https://unsplash.com/photos/a-woman-scubas-over-a-colorful-coral-reef-jTxhUMyPTrE
            @SerializedName("self")
            val self: String?, // https://api.unsplash.com/photos/a-woman-scubas-over-a-colorful-coral-reef-jTxhUMyPTrE
        )

        data class Sponsorship(
            @SerializedName("impression_urls")
            val impressionUrls: List<String?>?,
            @SerializedName("sponsor")
            val sponsor: Sponsor?,
            @SerializedName("tagline")
            val tagline: String?, // Made to Change
            @SerializedName("tagline_url")
            val taglineUrl: String?, // https://www.neom.com/en-us?utm_source=unsplash&utm_medium=referral
        ) {
            data class Sponsor(
                @SerializedName("accepted_tos")
                val acceptedTos: Boolean?, // true
                @SerializedName("bio")
                val bio: String?, // Located in the northwest of Saudi Arabia, NEOM’s diverse climate offers both sun-soaked beaches and snow-capped mountains. NEOM’s unique location will provide residents with enhanced livability while protecting 95% of the natural landscape.
                @SerializedName("first_name")
                val firstName: String?, // NEOM
                @SerializedName("for_hire")
                val forHire: Boolean?, // false
                @SerializedName("id")
                val id: String?, // mYizSrdJkkU
                @SerializedName("instagram_username")
                val instagramUsername: String?, // discoverneom
                @SerializedName("last_name")
                val lastName: Any?, // null
                @SerializedName("links")
                val links: Links?,
                @SerializedName("location")
                val location: String?, // NEOM, Saudi Arabia
                @SerializedName("name")
                val name: String?, // NEOM
                @SerializedName("portfolio_url")
                val portfolioUrl: String?, // http://www.neom.com
                @SerializedName("profile_image")
                val profileImage: ProfileImage?,
                @SerializedName("social")
                val social: Social?,
                @SerializedName("total_collections")
                val totalCollections: Int?, // 7
                @SerializedName("total_likes")
                val totalLikes: Int?, // 0
                @SerializedName("total_photos")
                val totalPhotos: Int?, // 202
                @SerializedName("twitter_username")
                val twitterUsername: String?, // neom
                @SerializedName("updated_at")
                val updatedAt: String?, // 2023-10-28T04:31:22Z
                @SerializedName("username")
                val username: String?, // neom
            ) {
                data class Links(
                    @SerializedName("followers")
                    val followers: String?, // https://api.unsplash.com/users/neom/followers
                    @SerializedName("following")
                    val following: String?, // https://api.unsplash.com/users/neom/following
                    @SerializedName("html")
                    val html: String?, // https://unsplash.com/@neom
                    @SerializedName("likes")
                    val likes: String?, // https://api.unsplash.com/users/neom/likes
                    @SerializedName("photos")
                    val photos: String?, // https://api.unsplash.com/users/neom/photos
                    @SerializedName("portfolio")
                    val portfolio: String?, // https://api.unsplash.com/users/neom/portfolio
                    @SerializedName("self")
                    val self: String?, // https://api.unsplash.com/users/neom
                )

                data class ProfileImage(
                    @SerializedName("large")
                    val large: String?, // https://images.unsplash.com/profile-1679489218992-ebe823c797dfimage?ixlib=rb-4.0.3&crop=faces&fit=crop&w=128&h=128
                    @SerializedName("medium")
                    val medium: String?, // https://images.unsplash.com/profile-1679489218992-ebe823c797dfimage?ixlib=rb-4.0.3&crop=faces&fit=crop&w=64&h=64
                    @SerializedName("small")
                    val small: String?, // https://images.unsplash.com/profile-1679489218992-ebe823c797dfimage?ixlib=rb-4.0.3&crop=faces&fit=crop&w=32&h=32
                )

                data class Social(
                    @SerializedName("instagram_username")
                    val instagramUsername: String?, // discoverneom
                    @SerializedName("paypal_email")
                    val paypalEmail: Any?, // null
                    @SerializedName("portfolio_url")
                    val portfolioUrl: String?, // http://www.neom.com
                    @SerializedName("twitter_username")
                    val twitterUsername: String?, // neom
                )
            }
        }

        class TopicSubmissions

        data class Urls(
            @SerializedName("full")
            val full: String?, // https://images.unsplash.com/photo-1682687981630-cefe9cd73072?crop=entropy&cs=srgb&fm=jpg&ixid=M3w1MTk4Njh8MXwxfGFsbHwxfHx8fHx8Mnx8MTY5ODUyMDE4MHw&ixlib=rb-4.0.3&q=85
            @SerializedName("raw")
            val raw: String?, // https://images.unsplash.com/photo-1682687981630-cefe9cd73072?ixid=M3w1MTk4Njh8MXwxfGFsbHwxfHx8fHx8Mnx8MTY5ODUyMDE4MHw&ixlib=rb-4.0.3
            @SerializedName("regular")
            val regular: String?, // https://images.unsplash.com/photo-1682687981630-cefe9cd73072?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3w1MTk4Njh8MXwxfGFsbHwxfHx8fHx8Mnx8MTY5ODUyMDE4MHw&ixlib=rb-4.0.3&q=80&w=1080
            @SerializedName("small")
            val small: String?, // https://images.unsplash.com/photo-1682687981630-cefe9cd73072?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3w1MTk4Njh8MXwxfGFsbHwxfHx8fHx8Mnx8MTY5ODUyMDE4MHw&ixlib=rb-4.0.3&q=80&w=400
            @SerializedName("small_s3")
            val smallS3: String?, // https://s3.us-west-2.amazonaws.com/images.unsplash.com/small/photo-1682687981630-cefe9cd73072
            @SerializedName("thumb")
            val thumb: String?, // https://images.unsplash.com/photo-1682687981630-cefe9cd73072?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3w1MTk4Njh8MXwxfGFsbHwxfHx8fHx8Mnx8MTY5ODUyMDE4MHw&ixlib=rb-4.0.3&q=80&w=200
        )

        data class User(
            @SerializedName("accepted_tos")
            val acceptedTos: Boolean?, // true
            @SerializedName("bio")
            val bio: String?, // Located in the northwest of Saudi Arabia, NEOM’s diverse climate offers both sun-soaked beaches and snow-capped mountains. NEOM’s unique location will provide residents with enhanced livability while protecting 95% of the natural landscape.
            @SerializedName("first_name")
            val firstName: String?, // NEOM
            @SerializedName("for_hire")
            val forHire: Boolean?, // false
            @SerializedName("id")
            val id: String?, // mYizSrdJkkU
            @SerializedName("instagram_username")
            val instagramUsername: String?, // discoverneom
            @SerializedName("last_name")
            val lastName: String?, // Figueroa
            @SerializedName("links")
            val links: Links?,
            @SerializedName("location")
            val location: String?, // NEOM, Saudi Arabia
            @SerializedName("name")
            val name: String?, // NEOM
            @SerializedName("portfolio_url")
            val portfolioUrl: String?, // http://www.neom.com
            @SerializedName("profile_image")
            val profileImage: ProfileImage?,
            @SerializedName("social")
            val social: Social?,
            @SerializedName("total_collections")
            val totalCollections: Int?, // 7
            @SerializedName("total_likes")
            val totalLikes: Int?, // 0
            @SerializedName("total_photos")
            val totalPhotos: Int?, // 202
            @SerializedName("twitter_username")
            val twitterUsername: String?, // neom
            @SerializedName("updated_at")
            val updatedAt: String?, // 2023-10-28T04:31:22Z
            @SerializedName("username")
            val username: String?, // neom
        ) {
            data class Links(
                @SerializedName("followers")
                val followers: String?, // https://api.unsplash.com/users/neom/followers
                @SerializedName("following")
                val following: String?, // https://api.unsplash.com/users/neom/following
                @SerializedName("html")
                val html: String?, // https://unsplash.com/@neom
                @SerializedName("likes")
                val likes: String?, // https://api.unsplash.com/users/neom/likes
                @SerializedName("photos")
                val photos: String?, // https://api.unsplash.com/users/neom/photos
                @SerializedName("portfolio")
                val portfolio: String?, // https://api.unsplash.com/users/neom/portfolio
                @SerializedName("self")
                val self: String?, // https://api.unsplash.com/users/neom
            )

            data class ProfileImage(
                @SerializedName("large")
                val large: String?, // https://images.unsplash.com/profile-1679489218992-ebe823c797dfimage?ixlib=rb-4.0.3&crop=faces&fit=crop&w=128&h=128
                @SerializedName("medium")
                val medium: String?, // https://images.unsplash.com/profile-1679489218992-ebe823c797dfimage?ixlib=rb-4.0.3&crop=faces&fit=crop&w=64&h=64
                @SerializedName("small")
                val small: String?, // https://images.unsplash.com/profile-1679489218992-ebe823c797dfimage?ixlib=rb-4.0.3&crop=faces&fit=crop&w=32&h=32
            )

            data class Social(
                @SerializedName("instagram_username")
                val instagramUsername: String?, // discoverneom
                @SerializedName("paypal_email")
                val paypalEmail: Any?, // null
                @SerializedName("portfolio_url")
                val portfolioUrl: String?, // http://www.neom.com
                @SerializedName("twitter_username")
                val twitterUsername: String?, // neom
            )
        }
    }
}
