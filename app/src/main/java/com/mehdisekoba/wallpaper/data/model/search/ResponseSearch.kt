package com.mehdisekoba.wallpaper.data.model.search

import com.google.gson.annotations.SerializedName

data class ResponseSearch(
    @SerializedName("results")
    val results: List<Result>?,
    @SerializedName("total")
    val total: Int?, // 10000
    @SerializedName("total_pages")
    val totalPages: Int?, // 1000
) {
    data class Result(
        @SerializedName("alt_description")
        val altDescription: String?, // yellow and white abstract painting
        @SerializedName("blur_hash")
        val blurHash: String?, // LHTR#grAbKs+pyi]afjsbdg3adf7
        @SerializedName("breadcrumbs")
        val breadcrumbs: List<Breadcrumb?>?,
        @SerializedName("color")
        val color: String?, // #f3f38c
        @SerializedName("created_at")
        val createdAt: String?, // 2020-12-09T11:38:19Z
        @SerializedName("current_user_collections")
        val currentUserCollections: List<Any?>?,
        @SerializedName("description")
        val description: String?, // Yellow cotton fabric
        @SerializedName("height")
        val height: Int?, // 5192
        @SerializedName("id")
        val id: String?, // PgqsTarkZDw
        @SerializedName("liked_by_user")
        val likedByUser: Boolean?, // false
        @SerializedName("likes")
        val likes: Int?, // 387
        @SerializedName("links")
        val links: Links?,
        @SerializedName("promoted_at")
        val promotedAt: String?, // 2020-12-10T10:41:53Z
        @SerializedName("slug")
        val slug: String?, // yellow-and-white-abstract-painting-PgqsTarkZDw
        @SerializedName("sponsorship")
        val sponsorship: Any?, // null
        @SerializedName("tags")
        val tags: List<Tag?>?,
        @SerializedName("topic_submissions")
        val topicSubmissions: TopicSubmissions?,
        @SerializedName("updated_at")
        val updatedAt: String?, // 2023-11-01T11:16:06Z
        @SerializedName("urls")
        val urls: Urls?,
        @SerializedName("user")
        val user: User?,
        @SerializedName("width")
        val width: Int?, // 3461
    ) {
        data class Breadcrumb(
            @SerializedName("index")
            val index: Int?, // 0
            @SerializedName("slug")
            val slug: String?, // backgrounds
            @SerializedName("title")
            val title: String?, // HQ Background Images
            @SerializedName("type")
            val type: String?, // landing_page
        )

        data class Links(
            @SerializedName("download")
            val download: String?, // https://unsplash.com/photos/PgqsTarkZDw/download?ixid=M3w1MTk4Njh8MHwxfHNlYXJjaHwxfHx5ZWxsb3d8ZW58MHx8fHwxNjk4ODUwMzIyfDA
            @SerializedName("download_location")
            val downloadLocation: String?, // https://api.unsplash.com/photos/PgqsTarkZDw/download?ixid=M3w1MTk4Njh8MHwxfHNlYXJjaHwxfHx5ZWxsb3d8ZW58MHx8fHwxNjk4ODUwMzIyfDA
            @SerializedName("html")
            val html: String?, // https://unsplash.com/photos/yellow-and-white-abstract-painting-PgqsTarkZDw
            @SerializedName("self")
            val self: String?, // https://api.unsplash.com/photos/yellow-and-white-abstract-painting-PgqsTarkZDw
        )

        data class Tag(
            @SerializedName("source")
            val source: Source?,
            @SerializedName("title")
            val title: String?, // yellow
            @SerializedName("type")
            val type: String?, // landing_page
        ) {
            data class Source(
                @SerializedName("ancestry")
                val ancestry: Ancestry?,
                @SerializedName("cover_photo")
                val coverPhoto: CoverPhoto?,
                @SerializedName("description")
                val description: String?, // Choose from a curated selection of yellow wallpapers for your mobile and desktop screens. Always free on Unsplash.
                @SerializedName("meta_description")
                val metaDescription: String?, // Choose from hundreds of free yellow wallpapers. Download HD wallpapers for free on Unsplash.
                @SerializedName("meta_title")
                val metaTitle: String?, // Yellow Wallpapers: Free HD Download [500+ HQ] | Unsplash
                @SerializedName("subtitle")
                val subtitle: String?, // Download free yellow wallpapers
                @SerializedName("title")
                val title: String?, // Hd yellow wallpapers
            ) {
                data class Ancestry(
                    @SerializedName("category")
                    val category: Category?,
                    @SerializedName("subcategory")
                    val subcategory: Subcategory?,
                    @SerializedName("type")
                    val type: Type?,
                ) {
                    data class Category(
                        @SerializedName("pretty_slug")
                        val prettySlug: String?, // Color
                        @SerializedName("slug")
                        val slug: String?, // colors
                    )

                    data class Subcategory(
                        @SerializedName("pretty_slug")
                        val prettySlug: String?, // Yellow
                        @SerializedName("slug")
                        val slug: String?, // yellow
                    )

                    data class Type(
                        @SerializedName("pretty_slug")
                        val prettySlug: String?, // HD Wallpapers
                        @SerializedName("slug")
                        val slug: String?, // wallpapers
                    )
                }

                data class CoverPhoto(
                    @SerializedName("alt_description")
                    val altDescription: String?, // flowers beside yellow wall
                    @SerializedName("blur_hash")
                    val blurHash: String?, // LQP=+Pxta$og%%j]WWj@Dhayofae
                    @SerializedName("breadcrumbs")
                    val breadcrumbs: List<Breadcrumb?>?,
                    @SerializedName("color")
                    val color: String?, // #d9c0a6
                    @SerializedName("created_at")
                    val createdAt: String?, // 2017-02-15T08:32:55Z
                    @SerializedName("current_user_collections")
                    val currentUserCollections: List<Any?>?,
                    @SerializedName("description")
                    val description: String?, // Find more inspiring photos: https://monaeendra.com/
                    @SerializedName("height")
                    val height: Int?, // 5184
                    @SerializedName("id")
                    val id: String?, // vC8wj_Kphak
                    @SerializedName("liked_by_user")
                    val likedByUser: Boolean?, // false
                    @SerializedName("likes")
                    val likes: Int?, // 13409
                    @SerializedName("links")
                    val links: Links?,
                    @SerializedName("plus")
                    val plus: Boolean?, // false
                    @SerializedName("premium")
                    val premium: Boolean?, // false
                    @SerializedName("promoted_at")
                    val promotedAt: String?, // 2017-02-15T08:32:55Z
                    @SerializedName("slug")
                    val slug: String?, // flowers-beside-yellow-wall-vC8wj_Kphak
                    @SerializedName("sponsorship")
                    val sponsorship: Any?, // null
                    @SerializedName("topic_submissions")
                    val topicSubmissions: TopicSubmissions?,
                    @SerializedName("updated_at")
                    val updatedAt: String?, // 2023-10-29T20:01:04Z
                    @SerializedName("urls")
                    val urls: Urls?,
                    @SerializedName("user")
                    val user: User?,
                    @SerializedName("width")
                    val width: Int?, // 3456
                ) {
                    data class Breadcrumb(
                        @SerializedName("index")
                        val index: Int?, // 0
                        @SerializedName("slug")
                        val slug: String?, // backgrounds
                        @SerializedName("title")
                        val title: String?, // HQ Background Images
                        @SerializedName("type")
                        val type: String?, // landing_page
                    )

                    data class Links(
                        @SerializedName("download")
                        val download: String?, // https://unsplash.com/photos/vC8wj_Kphak/download
                        @SerializedName("download_location")
                        val downloadLocation: String?, // https://api.unsplash.com/photos/vC8wj_Kphak/download
                        @SerializedName("html")
                        val html: String?, // https://unsplash.com/photos/flowers-beside-yellow-wall-vC8wj_Kphak
                        @SerializedName("self")
                        val self: String?, // https://api.unsplash.com/photos/flowers-beside-yellow-wall-vC8wj_Kphak
                    )

                    data class TopicSubmissions(
                        @SerializedName("architecture-interior")
                        val architectureInterior: ArchitectureInterior?,
                        @SerializedName("color-of-water")
                        val colorOfWater: ColorOfWater?,
                        @SerializedName("health")
                        val health: Health?,
                        @SerializedName("nature")
                        val nature: Nature?,
                        @SerializedName("textures-patterns")
                        val texturesPatterns: TexturesPatterns?,
                        @SerializedName("wallpapers")
                        val wallpapers: Wallpapers?,
                    ) {
                        data class ArchitectureInterior(
                            @SerializedName("approved_on")
                            val approvedOn: String?, // 2020-04-06T14:20:14Z
                            @SerializedName("status")
                            val status: String?, // approved
                        )

                        data class ColorOfWater(
                            @SerializedName("approved_on")
                            val approvedOn: String?, // 2022-04-21T15:04:21Z
                            @SerializedName("status")
                            val status: String?, // approved
                        )

                        data class Health(
                            @SerializedName("approved_on")
                            val approvedOn: String?, // 2020-04-06T14:20:25Z
                            @SerializedName("status")
                            val status: String?, // approved
                        )

                        data class Nature(
                            @SerializedName("approved_on")
                            val approvedOn: String?, // 2020-04-06T14:20:12Z
                            @SerializedName("status")
                            val status: String?, // approved
                        )

                        data class TexturesPatterns(
                            @SerializedName("approved_on")
                            val approvedOn: String?, // 2020-04-06T14:20:11Z
                            @SerializedName("status")
                            val status: String?, // approved
                        )

                        data class Wallpapers(
                            @SerializedName("approved_on")
                            val approvedOn: String?, // 2020-04-06T14:20:09Z
                            @SerializedName("status")
                            val status: String?, // approved
                        )
                    }

                    data class Urls(
                        @SerializedName("full")
                        val full: String?, // https://images.unsplash.com/photo-1487147264018-f937fba0c817?ixlib=rb-4.0.3&q=85&fm=jpg&crop=entropy&cs=srgb
                        @SerializedName("raw")
                        val raw: String?, // https://images.unsplash.com/photo-1487147264018-f937fba0c817?ixlib=rb-4.0.3
                        @SerializedName("regular")
                        val regular: String?, // https://images.unsplash.com/photo-1487147264018-f937fba0c817?ixlib=rb-4.0.3&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&fit=max
                        @SerializedName("small")
                        val small: String?, // https://images.unsplash.com/photo-1487147264018-f937fba0c817?ixlib=rb-4.0.3&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=400&fit=max
                        @SerializedName("small_s3")
                        val smallS3: String?, // https://s3.us-west-2.amazonaws.com/images.unsplash.com/small/photo-1487147264018-f937fba0c817
                        @SerializedName("thumb")
                        val thumb: String?, // https://images.unsplash.com/photo-1487147264018-f937fba0c817?ixlib=rb-4.0.3&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=200&fit=max
                    )

                    data class User(
                        @SerializedName("accepted_tos")
                        val acceptedTos: Boolean?, // false
                        @SerializedName("bio")
                        val bio: String?, // Passionate photographer capturing beauty and soul in people and places. I am available for collaborations!
                        @SerializedName("first_name")
                        val firstName: String?, // Mona
                        @SerializedName("for_hire")
                        val forHire: Boolean?, // true
                        @SerializedName("id")
                        val id: String?, // -tVYuvmMiPA
                        @SerializedName("instagram_username")
                        val instagramUsername: String?, // monaeendra
                        @SerializedName("last_name")
                        val lastName: String?, // Eendra
                        @SerializedName("links")
                        val links: Links?,
                        @SerializedName("location")
                        val location: String?, // Copenhagen
                        @SerializedName("name")
                        val name: String?, // Mona Eendra
                        @SerializedName("portfolio_url")
                        val portfolioUrl: String?, // https://monaeendra.com/
                        @SerializedName("profile_image")
                        val profileImage: ProfileImage?,
                        @SerializedName("social")
                        val social: Social?,
                        @SerializedName("total_collections")
                        val totalCollections: Int?, // 0
                        @SerializedName("total_likes")
                        val totalLikes: Int?, // 289
                        @SerializedName("total_photos")
                        val totalPhotos: Int?, // 39
                        @SerializedName("twitter_username")
                        val twitterUsername: String?, // pm_cze
                        @SerializedName("updated_at")
                        val updatedAt: String?, // 2023-09-12T22:28:45Z
                        @SerializedName("username")
                        val username: String?, // monaeendra
                    ) {
                        data class Links(
                            @SerializedName("followers")
                            val followers: String?, // https://api.unsplash.com/users/monaeendra/followers
                            @SerializedName("following")
                            val following: String?, // https://api.unsplash.com/users/monaeendra/following
                            @SerializedName("html")
                            val html: String?, // https://unsplash.com/@monaeendra
                            @SerializedName("likes")
                            val likes: String?, // https://api.unsplash.com/users/monaeendra/likes
                            @SerializedName("photos")
                            val photos: String?, // https://api.unsplash.com/users/monaeendra/photos
                            @SerializedName("portfolio")
                            val portfolio: String?, // https://api.unsplash.com/users/monaeendra/portfolio
                            @SerializedName("self")
                            val self: String?, // https://api.unsplash.com/users/monaeendra
                        )

                        data class ProfileImage(
                            @SerializedName("large")
                            val large: String?, // https://images.unsplash.com/profile-1470086144548-9b86aec8f374?ixlib=rb-4.0.3&crop=faces&fit=crop&w=128&h=128
                            @SerializedName("medium")
                            val medium: String?, // https://images.unsplash.com/profile-1470086144548-9b86aec8f374?ixlib=rb-4.0.3&crop=faces&fit=crop&w=64&h=64
                            @SerializedName("small")
                            val small: String?, // https://images.unsplash.com/profile-1470086144548-9b86aec8f374?ixlib=rb-4.0.3&crop=faces&fit=crop&w=32&h=32
                        )

                        data class Social(
                            @SerializedName("instagram_username")
                            val instagramUsername: String?, // monaeendra
                            @SerializedName("paypal_email")
                            val paypalEmail: Any?, // null
                            @SerializedName("portfolio_url")
                            val portfolioUrl: String?, // https://monaeendra.com/
                            @SerializedName("twitter_username")
                            val twitterUsername: String?, // pm_cze
                        )
                    }
                }
            }
        }

        data class TopicSubmissions(
            @SerializedName("arts-culture")
            val artsCulture: ArtsCulture?,
            @SerializedName("color-of-water")
            val colorOfWater: ColorOfWater?,
            @SerializedName("textures-patterns")
            val texturesPatterns: TexturesPatterns?,
        ) {
            data class ArtsCulture(
                @SerializedName("approved_on")
                val approvedOn: String?, // 2020-11-24T12:32:31Z
                @SerializedName("status")
                val status: String?, // approved
            )

            data class ColorOfWater(
                @SerializedName("approved_on")
                val approvedOn: String?, // 2022-03-28T09:12:32Z
                @SerializedName("status")
                val status: String?, // approved
            )

            data class TexturesPatterns(
                @SerializedName("approved_on")
                val approvedOn: String?, // 2021-01-26T13:29:02Z
                @SerializedName("status")
                val status: String?, // approved
            )
        }

        data class Urls(
            @SerializedName("full")
            val full: String?, // https://images.unsplash.com/photo-1607513746994-51f730a44832?crop=entropy&cs=srgb&fm=jpg&ixid=M3w1MTk4Njh8MHwxfHNlYXJjaHwxfHx5ZWxsb3d8ZW58MHx8fHwxNjk4ODUwMzIyfDA&ixlib=rb-4.0.3&q=85
            @SerializedName("raw")
            val raw: String?, // https://images.unsplash.com/photo-1607513746994-51f730a44832?ixid=M3w1MTk4Njh8MHwxfHNlYXJjaHwxfHx5ZWxsb3d8ZW58MHx8fHwxNjk4ODUwMzIyfDA&ixlib=rb-4.0.3
            @SerializedName("regular")
            val regular: String?, // https://images.unsplash.com/photo-1607513746994-51f730a44832?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3w1MTk4Njh8MHwxfHNlYXJjaHwxfHx5ZWxsb3d8ZW58MHx8fHwxNjk4ODUwMzIyfDA&ixlib=rb-4.0.3&q=80&w=1080
            @SerializedName("small")
            val small: String?, // https://images.unsplash.com/photo-1607513746994-51f730a44832?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3w1MTk4Njh8MHwxfHNlYXJjaHwxfHx5ZWxsb3d8ZW58MHx8fHwxNjk4ODUwMzIyfDA&ixlib=rb-4.0.3&q=80&w=400
            @SerializedName("small_s3")
            val smallS3: String?, // https://s3.us-west-2.amazonaws.com/images.unsplash.com/small/photo-1607513746994-51f730a44832
            @SerializedName("thumb")
            val thumb: String?, // https://images.unsplash.com/photo-1607513746994-51f730a44832?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3w1MTk4Njh8MHwxfHNlYXJjaHwxfHx5ZWxsb3d8ZW58MHx8fHwxNjk4ODUwMzIyfDA&ixlib=rb-4.0.3&q=80&w=200
        )

        data class User(
            @SerializedName("accepted_tos")
            val acceptedTos: Boolean?, // true
            @SerializedName("bio")
            val bio: String?, // - Photos cannot be sold without significant modification.- Instagram @jeileephoto 💌 jeileephoto@gmail.com
            @SerializedName("first_name")
            val firstName: String?, // J
            @SerializedName("for_hire")
            val forHire: Boolean?, // false
            @SerializedName("id")
            val id: String?, // 10TBkQXmnSI
            @SerializedName("instagram_username")
            val instagramUsername: String?, // jeileephoto
            @SerializedName("last_name")
            val lastName: String?, // Lee
            @SerializedName("links")
            val links: Links?,
            @SerializedName("location")
            val location: String?, // South Korea
            @SerializedName("name")
            val name: String?, // J Lee
            @SerializedName("portfolio_url")
            val portfolioUrl: String?, // http://davidpisnoy.com
            @SerializedName("profile_image")
            val profileImage: ProfileImage?,
            @SerializedName("social")
            val social: Social?,
            @SerializedName("total_collections")
            val totalCollections: Int?, // 0
            @SerializedName("total_likes")
            val totalLikes: Int?, // 0
            @SerializedName("total_photos")
            val totalPhotos: Int?, // 62
            @SerializedName("twitter_username")
            val twitterUsername: String?, // davidpisnoy
            @SerializedName("updated_at")
            val updatedAt: String?, // 2023-11-01T12:13:06Z
            @SerializedName("username")
            val username: String?, // babybluecat
        ) {
            data class Links(
                @SerializedName("followers")
                val followers: String?, // https://api.unsplash.com/users/babybluecat/followers
                @SerializedName("following")
                val following: String?, // https://api.unsplash.com/users/babybluecat/following
                @SerializedName("html")
                val html: String?, // https://unsplash.com/@babybluecat
                @SerializedName("likes")
                val likes: String?, // https://api.unsplash.com/users/babybluecat/likes
                @SerializedName("photos")
                val photos: String?, // https://api.unsplash.com/users/babybluecat/photos
                @SerializedName("portfolio")
                val portfolio: String?, // https://api.unsplash.com/users/babybluecat/portfolio
                @SerializedName("self")
                val self: String?, // https://api.unsplash.com/users/babybluecat
            )

            data class ProfileImage(
                @SerializedName("large")
                val large: String?, // https://images.unsplash.com/profile-1599012749910-0d86a35844cdimage?ixlib=rb-4.0.3&crop=faces&fit=crop&w=128&h=128
                @SerializedName("medium")
                val medium: String?, // https://images.unsplash.com/profile-1599012749910-0d86a35844cdimage?ixlib=rb-4.0.3&crop=faces&fit=crop&w=64&h=64
                @SerializedName("small")
                val small: String?, // https://images.unsplash.com/profile-1599012749910-0d86a35844cdimage?ixlib=rb-4.0.3&crop=faces&fit=crop&w=32&h=32
            )

            data class Social(
                @SerializedName("instagram_username")
                val instagramUsername: String?, // jeileephoto
                @SerializedName("paypal_email")
                val paypalEmail: Any?, // null
                @SerializedName("portfolio_url")
                val portfolioUrl: String?, // http://davidpisnoy.com
                @SerializedName("twitter_username")
                val twitterUsername: String?, // davidpisnoy
            )
        }
    }
}
