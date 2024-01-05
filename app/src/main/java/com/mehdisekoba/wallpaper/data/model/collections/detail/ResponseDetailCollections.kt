package com.mehdisekoba.wallpaper.data.model.collections.detail

import com.google.gson.annotations.SerializedName

class ResponseDetailCollections :
    ArrayList<ResponseDetailCollections.ResponseDetailCollectionsItem>() {
    data class ResponseDetailCollectionsItem(
        @SerializedName("alt_description")
        val altDescription: String?, // a cabin in the middle of a snowy forest
        @SerializedName("blur_hash")
        val blurHash: String?, // LjLO1pxut7jsE3RkRiof_4WCaxof
        @SerializedName("breadcrumbs")
        val breadcrumbs: List<Any?>?,
        @SerializedName("color")
        val color: String?, // #f3f3f3
        @SerializedName("created_at")
        val createdAt: String?, // 2022-02-12T19:03:06Z
        @SerializedName("current_user_collections")
        val currentUserCollections: List<Any?>?,
        @SerializedName("description")
        val description: String?, // Girl in snow
        @SerializedName("height")
        val height: Int?, // 6140
        @SerializedName("id")
        val id: String?, // NVruVp35vyI
        @SerializedName("liked_by_user")
        val likedByUser: Boolean?, // false
        @SerializedName("likes")
        val likes: Int?, // 64
        @SerializedName("links")
        val links: Links?,
        @SerializedName("promoted_at")
        val promotedAt: String?, // 2022-02-13T11:40:01Z
        @SerializedName("slug")
        val slug: String?, // a-cabin-in-the-middle-of-a-snowy-forest-NVruVp35vyI
        @SerializedName("sponsorship")
        val sponsorship: Any?, // null
        @SerializedName("topic_submissions")
        val topicSubmissions: TopicSubmissions?,
        @SerializedName("updated_at")
        val updatedAt: String?, // 2023-12-23T11:29:47Z
        @SerializedName("urls")
        val urls: Urls?,
        @SerializedName("user")
        val user: User?,
        @SerializedName("width")
        val width: Int?, // 4093
    ) {
        data class Links(
            @SerializedName("download")
            val download: String?, // https://unsplash.com/photos/NVruVp35vyI/download?ixid=M3w1NDA2NzJ8MHwxfGNvbGxlY3Rpb258MXwzNDY5NDc1fHx8fHwyfHwxNzAzMzM4Mzk1fA
            @SerializedName("download_location")
            val downloadLocation: String?, // https://api.unsplash.com/photos/NVruVp35vyI/download?ixid=M3w1NDA2NzJ8MHwxfGNvbGxlY3Rpb258MXwzNDY5NDc1fHx8fHwyfHwxNzAzMzM4Mzk1fA
            @SerializedName("html")
            val html: String?, // https://unsplash.com/photos/a-cabin-in-the-middle-of-a-snowy-forest-NVruVp35vyI
            @SerializedName("self")
            val self: String?, // https://api.unsplash.com/photos/a-cabin-in-the-middle-of-a-snowy-forest-NVruVp35vyI
        )

        data class TopicSubmissions(
            @SerializedName("interiors")
            val interiors: Interiors?,
            @SerializedName("nature")
            val nature: Nature?,
        ) {
            data class Interiors(
                @SerializedName("status")
                val status: String?, // rejected
            )

            data class Nature(
                @SerializedName("approved_on")
                val approvedOn: String?, // 2022-02-14T13:10:15Z
                @SerializedName("status")
                val status: String?, // approved
            )
        }

        data class Urls(
            @SerializedName("full")
            val full: String?, // https://images.unsplash.com/photo-1644692385181-a3ba9ee47f84?crop=entropy&cs=srgb&fm=jpg&ixid=M3w1NDA2NzJ8MHwxfGNvbGxlY3Rpb258MXwzNDY5NDc1fHx8fHwyfHwxNzAzMzM4Mzk1fA&ixlib=rb-4.0.3&q=85
            @SerializedName("raw")
            val raw: String?, // https://images.unsplash.com/photo-1644692385181-a3ba9ee47f84?ixid=M3w1NDA2NzJ8MHwxfGNvbGxlY3Rpb258MXwzNDY5NDc1fHx8fHwyfHwxNzAzMzM4Mzk1fA&ixlib=rb-4.0.3
            @SerializedName("regular")
            val regular: String?, // https://images.unsplash.com/photo-1644692385181-a3ba9ee47f84?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3w1NDA2NzJ8MHwxfGNvbGxlY3Rpb258MXwzNDY5NDc1fHx8fHwyfHwxNzAzMzM4Mzk1fA&ixlib=rb-4.0.3&q=80&w=1080
            @SerializedName("small")
            val small: String?, // https://images.unsplash.com/photo-1644692385181-a3ba9ee47f84?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3w1NDA2NzJ8MHwxfGNvbGxlY3Rpb258MXwzNDY5NDc1fHx8fHwyfHwxNzAzMzM4Mzk1fA&ixlib=rb-4.0.3&q=80&w=400
            @SerializedName("small_s3")
            val smallS3: String?, // https://s3.us-west-2.amazonaws.com/images.unsplash.com/small/photo-1644692385181-a3ba9ee47f84
            @SerializedName("thumb")
            val thumb: String?, // https://images.unsplash.com/photo-1644692385181-a3ba9ee47f84?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3w1NDA2NzJ8MHwxfGNvbGxlY3Rpb258MXwzNDY5NDc1fHx8fHwyfHwxNzAzMzM4Mzk1fA&ixlib=rb-4.0.3&q=80&w=200
        )

        data class User(
            @SerializedName("accepted_tos")
            val acceptedTos: Boolean?, // true
            @SerializedName("bio")
            val bio: String?, // Content Creator & DesignerLiving life collecting stories
            @SerializedName("first_name")
            val firstName: String?, // Alsu
            @SerializedName("for_hire")
            val forHire: Boolean?, // true
            @SerializedName("id")
            val id: String?, // YoSeY2056lc
            @SerializedName("instagram_username")
            val instagramUsername: String?, // Alsyvert
            @SerializedName("last_name")
            val lastName: String?, // Vershinina
            @SerializedName("links")
            val links: Links?,
            @SerializedName("location")
            val location: String?, // Saint-Petersburg
            @SerializedName("name")
            val name: String?, // Alsu Vershinina
            @SerializedName("portfolio_url")
            val portfolioUrl: String?, // https://instagram.com/alsyvert
            @SerializedName("profile_image")
            val profileImage: ProfileImage?,
            @SerializedName("social")
            val social: Social?,
            @SerializedName("total_collections")
            val totalCollections: Int?, // 9
            @SerializedName("total_likes")
            val totalLikes: Int?, // 20
            @SerializedName("total_photos")
            val totalPhotos: Int?, // 217
            @SerializedName("total_promoted_photos")
            val totalPromotedPhotos: Int?, // 44
            @SerializedName("twitter_username")
            val twitterUsername: Any?, // null
            @SerializedName("updated_at")
            val updatedAt: String?, // 2023-12-14T02:51:55Z
            @SerializedName("username")
            val username: String?, // alsyshka
        ) {
            data class Links(
                @SerializedName("followers")
                val followers: String?, // https://api.unsplash.com/users/alsyshka/followers
                @SerializedName("following")
                val following: String?, // https://api.unsplash.com/users/alsyshka/following
                @SerializedName("html")
                val html: String?, // https://unsplash.com/@alsyshka
                @SerializedName("likes")
                val likes: String?, // https://api.unsplash.com/users/alsyshka/likes
                @SerializedName("photos")
                val photos: String?, // https://api.unsplash.com/users/alsyshka/photos
                @SerializedName("portfolio")
                val portfolio: String?, // https://api.unsplash.com/users/alsyshka/portfolio
                @SerializedName("self")
                val self: String?, // https://api.unsplash.com/users/alsyshka
            )

            data class ProfileImage(
                @SerializedName("large")
                val large: String?, // https://images.unsplash.com/profile-1645096154755-572f2e55e140?ixlib=rb-4.0.3&crop=faces&fit=crop&w=128&h=128
                @SerializedName("medium")
                val medium: String?, // https://images.unsplash.com/profile-1645096154755-572f2e55e140?ixlib=rb-4.0.3&crop=faces&fit=crop&w=64&h=64
                @SerializedName("small")
                val small: String?, // https://images.unsplash.com/profile-1645096154755-572f2e55e140?ixlib=rb-4.0.3&crop=faces&fit=crop&w=32&h=32
            )

            data class Social(
                @SerializedName("instagram_username")
                val instagramUsername: String?, // Alsyvert
                @SerializedName("paypal_email")
                val paypalEmail: Any?, // null
                @SerializedName("portfolio_url")
                val portfolioUrl: String?, // https://instagram.com/alsyvert
                @SerializedName("twitter_username")
                val twitterUsername: Any?, // null
            )
        }
    }
}
