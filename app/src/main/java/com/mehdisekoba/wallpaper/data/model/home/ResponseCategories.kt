package com.mehdisekoba.wallpaper.data.model.home

import com.google.gson.annotations.SerializedName

class ResponseCategories : ArrayList<ResponseCategories.ResponseCategoriesItem>() {
    data class ResponseCategoriesItem(
        @SerializedName("cover_photo")
        val coverPhoto: CoverPhoto?,
        @SerializedName("current_user_contributions")
        val currentUserContributions: List<Any?>?,
        @SerializedName("description")
        val description: String?, // Blending technology and artistry, the 3D Renders category showcases digitally rendered creations that blur the lines between reality and imagination. From architectural visualizations to fantastical worlds, this category exhibits the limitless possibilities of digital craftsmanship.
        @SerializedName("ends_at")
        val endsAt: Any?, // null
        @SerializedName("featured")
        val featured: Boolean?, // true
        @SerializedName("id")
        val id: String?, // CDwuwXJAbEw
        @SerializedName("links")
        val links: Links?,
        @SerializedName("only_submissions_after")
        val onlySubmissionsAfter: String?, // 2022-12-01T12:00:00Z
        @SerializedName("owners")
        val owners: List<Owner?>?,
        @SerializedName("preview_photos")
        val previewPhotos: List<PreviewPhoto?>?,
        @SerializedName("published_at")
        val publishedAt: String?, // 2021-06-16T18:09:53Z
        @SerializedName("slug")
        val slug: String?, // 3d-renders
        @SerializedName("starts_at")
        val startsAt: String?, // 2022-12-01T00:00:00Z
        @SerializedName("status")
        val status: String?, // open
        @SerializedName("title")
        val title: String?, // 3D Renders
        @SerializedName("total_current_user_submissions")
        val totalCurrentUserSubmissions: Any?, // null
        @SerializedName("total_photos")
        val totalPhotos: Int?, // 6927
        @SerializedName("updated_at")
        val updatedAt: String?, // 2023-10-30T09:38:28Z
        @SerializedName("visibility")
        val visibility: String?, // featured
    ) {
        data class CoverPhoto(
            @SerializedName("alt_description")
            val altDescription: String?, // a multicolored abstract background with curved lines
            @SerializedName("blur_hash")
            val blurHash: String?, // LGBf6XoBcYf-FEo#JPS6rpoz,vNX
            @SerializedName("breadcrumbs")
            val breadcrumbs: List<Any?>?,
            @SerializedName("color")
            val color: String?, // #734059
            @SerializedName("created_at")
            val createdAt: String?, // 2023-06-02T00:25:18Z
            @SerializedName("current_user_collections")
            val currentUserCollections: List<Any?>?,
            @SerializedName("description")
            val description: String?, // Building in Biscayne Blvd, Miami, Florida
            @SerializedName("height")
            val height: Int?, // 6000
            @SerializedName("id")
            val id: String?, // Qdg8WXu0yrI
            @SerializedName("liked_by_user")
            val likedByUser: Boolean?, // false
            @SerializedName("likes")
            val likes: Int?, // 90
            @SerializedName("links")
            val links: Links?,
            @SerializedName("promoted_at")
            val promotedAt: String?, // 2023-06-03T08:24:01Z
            @SerializedName("slug")
            val slug: String?, // a-multicolored-abstract-background-with-curved-lines-Qdg8WXu0yrI
            @SerializedName("sponsorship")
            val sponsorship: Any?, // null
            @SerializedName("topic_submissions")
            val topicSubmissions: TopicSubmissions?,
            @SerializedName("updated_at")
            val updatedAt: String?, // 2023-10-30T09:38:28Z
            @SerializedName("urls")
            val urls: Urls?,
            @SerializedName("user")
            val user: User?,
            @SerializedName("width")
            val width: Int?, // 4000
        ) {
            data class Links(
                @SerializedName("download")
                val download: String?, // https://unsplash.com/photos/Qdg8WXu0yrI/download
                @SerializedName("download_location")
                val downloadLocation: String?, // https://api.unsplash.com/photos/Qdg8WXu0yrI/download
                @SerializedName("html")
                val html: String?, // https://unsplash.com/photos/a-multicolored-abstract-background-with-curved-lines-Qdg8WXu0yrI
                @SerializedName("self")
                val self: String?, // https://api.unsplash.com/photos/a-multicolored-abstract-background-with-curved-lines-Qdg8WXu0yrI
            )

            data class TopicSubmissions(
                @SerializedName("animals")
                val animals: Animals?,
                @SerializedName("architecture-interior")
                val architectureInterior: ArchitectureInterior?,
                @SerializedName("3d-renders")
                val dRenders: DRenders?,
                @SerializedName("experimental")
                val experimental: Experimental?,
                @SerializedName("fashion-beauty")
                val fashionBeauty: FashionBeauty?,
                @SerializedName("film")
                val film: Film?,
                @SerializedName("nature")
                val nature: Nature?,
                @SerializedName("people")
                val people: People?,
                @SerializedName("sports")
                val sports: Sports?,
                @SerializedName("travel")
                val travel: Travel?,
            ) {
                data class Animals(
                    @SerializedName("approved_on")
                    val approvedOn: String?, // 2023-10-30T14:54:39Z
                    @SerializedName("status")
                    val status: String?, // approved
                )

                data class ArchitectureInterior(
                    @SerializedName("approved_on")
                    val approvedOn: String?, // 2023-10-29T20:42:34Z
                    @SerializedName("status")
                    val status: String?, // approved
                )

                data class DRenders(
                    @SerializedName("approved_on")
                    val approvedOn: String?, // 2023-10-30T09:38:28Z
                    @SerializedName("status")
                    val status: String?, // approved
                )

                data class Experimental(
                    @SerializedName("approved_on")
                    val approvedOn: String?, // 2023-10-30T15:03:16Z
                    @SerializedName("status")
                    val status: String?, // approved
                )

                data class FashionBeauty(
                    @SerializedName("approved_on")
                    val approvedOn: String?, // 2023-10-27T08:17:47Z
                    @SerializedName("status")
                    val status: String?, // approved
                )

                data class Film(
                    @SerializedName("approved_on")
                    val approvedOn: String?, // 2023-10-30T07:32:01Z
                    @SerializedName("status")
                    val status: String?, // approved
                )

                data class Nature(
                    @SerializedName("approved_on")
                    val approvedOn: String?, // 2023-10-30T15:25:26Z
                    @SerializedName("status")
                    val status: String?, // approved
                )

                data class People(
                    @SerializedName("approved_on")
                    val approvedOn: String?, // 2023-10-27T08:19:53Z
                    @SerializedName("status")
                    val status: String?, // approved
                )

                data class Sports(
                    @SerializedName("approved_on")
                    val approvedOn: String?, // 2023-10-27T08:16:27Z
                    @SerializedName("status")
                    val status: String?, // approved
                )

                data class Travel(
                    @SerializedName("approved_on")
                    val approvedOn: String?, // 2023-10-27T08:19:14Z
                    @SerializedName("status")
                    val status: String?, // unevaluated
                )
            }

            data class Urls(
                @SerializedName("full")
                val full: String?, // https://images.unsplash.com/photo-1685665509769-3a907848565f?ixlib=rb-4.0.3&q=85&fm=jpg&crop=entropy&cs=srgb
                @SerializedName("raw")
                val raw: String?, // https://images.unsplash.com/photo-1685665509769-3a907848565f?ixlib=rb-4.0.3
                @SerializedName("regular")
                val regular: String?, // https://images.unsplash.com/photo-1685665509769-3a907848565f?ixlib=rb-4.0.3&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&fit=max
                @SerializedName("small")
                val small: String?, // https://images.unsplash.com/photo-1685665509769-3a907848565f?ixlib=rb-4.0.3&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=400&fit=max
                @SerializedName("small_s3")
                val smallS3: String?, // https://s3.us-west-2.amazonaws.com/images.unsplash.com/small/photo-1685665509769-3a907848565f
                @SerializedName("thumb")
                val thumb: String?, // https://images.unsplash.com/photo-1685665509769-3a907848565f?ixlib=rb-4.0.3&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=200&fit=max
            )

            data class User(
                @SerializedName("accepted_tos")
                val acceptedTos: Boolean?, // true
                @SerializedName("bio")
                val bio: String?, // Not all geometry is created equal!
                @SerializedName("first_name")
                val firstName: String?, // Sufyan
                @SerializedName("for_hire")
                val forHire: Boolean?, // false
                @SerializedName("id")
                val id: String?, // yHabkNEdUC8
                @SerializedName("instagram_username")
                val instagramUsername: String?, // jakub_neskora
                @SerializedName("last_name")
                val lastName: String?, // Neskora
                @SerializedName("links")
                val links: Links?,
                @SerializedName("location")
                val location: String?, // FL
                @SerializedName("name")
                val name: String?, // Sufyan
                @SerializedName("portfolio_url")
                val portfolioUrl: String?, // https://miamiphotographe.myportfolio.com/
                @SerializedName("profile_image")
                val profileImage: ProfileImage?,
                @SerializedName("social")
                val social: Social?,
                @SerializedName("total_collections")
                val totalCollections: Int?, // 14
                @SerializedName("total_likes")
                val totalLikes: Int?, // 970
                @SerializedName("total_photos")
                val totalPhotos: Int?, // 499
                @SerializedName("twitter_username")
                val twitterUsername: String?, // hectorfalcon50
                @SerializedName("updated_at")
                val updatedAt: String?, // 2023-10-30T15:01:40Z
                @SerializedName("username")
                val username: String?, // blenderdesigner_1688
            ) {
                data class Links(
                    @SerializedName("followers")
                    val followers: String?, // https://api.unsplash.com/users/blenderdesigner_1688/followers
                    @SerializedName("following")
                    val following: String?, // https://api.unsplash.com/users/blenderdesigner_1688/following
                    @SerializedName("html")
                    val html: String?, // https://unsplash.com/@blenderdesigner_1688
                    @SerializedName("likes")
                    val likes: String?, // https://api.unsplash.com/users/blenderdesigner_1688/likes
                    @SerializedName("photos")
                    val photos: String?, // https://api.unsplash.com/users/blenderdesigner_1688/photos
                    @SerializedName("portfolio")
                    val portfolio: String?, // https://api.unsplash.com/users/blenderdesigner_1688/portfolio
                    @SerializedName("self")
                    val self: String?, // https://api.unsplash.com/users/blenderdesigner_1688
                )

                data class ProfileImage(
                    @SerializedName("large")
                    val large: String?, // https://images.unsplash.com/profile-1695401171172-360cf086baf4image?ixlib=rb-4.0.3&crop=faces&fit=crop&w=128&h=128
                    @SerializedName("medium")
                    val medium: String?, // https://images.unsplash.com/profile-1695401171172-360cf086baf4image?ixlib=rb-4.0.3&crop=faces&fit=crop&w=64&h=64
                    @SerializedName("small")
                    val small: String?, // https://images.unsplash.com/profile-1695401171172-360cf086baf4image?ixlib=rb-4.0.3&crop=faces&fit=crop&w=32&h=32
                )

                data class Social(
                    @SerializedName("instagram_username")
                    val instagramUsername: String?, // jakub_neskora
                    @SerializedName("paypal_email")
                    val paypalEmail: Any?, // null
                    @SerializedName("portfolio_url")
                    val portfolioUrl: String?, // https://miamiphotographe.myportfolio.com/
                    @SerializedName("twitter_username")
                    val twitterUsername: String?, // hectorfalcon50
                )
            }
        }

        data class Links(
            @SerializedName("html")
            val html: String?, // https://unsplash.com/t/3d-renders
            @SerializedName("photos")
            val photos: String?, // https://api.unsplash.com/topics/3d-renders/photos
            @SerializedName("self")
            val self: String?, // https://api.unsplash.com/topics/3d-renders
        )

        data class Owner(
            @SerializedName("accepted_tos")
            val acceptedTos: Boolean?, // true
            @SerializedName("bio")
            val bio: String?, // Behind the scenes of the team building the internet’s open library of freely useable visuals.
            @SerializedName("first_name")
            val firstName: String?, // Unsplash
            @SerializedName("for_hire")
            val forHire: Boolean?, // false
            @SerializedName("id")
            val id: String?, // QV5S1rtoUJ0
            @SerializedName("instagram_username")
            val instagramUsername: String?, // unsplash
            @SerializedName("last_name")
            val lastName: Any?, // null
            @SerializedName("links")
            val links: Links?,
            @SerializedName("location")
            val location: String?, // Montreal, Canada
            @SerializedName("name")
            val name: String?, // Unsplash
            @SerializedName("portfolio_url")
            val portfolioUrl: String?, // https://unsplash.com
            @SerializedName("profile_image")
            val profileImage: ProfileImage?,
            @SerializedName("social")
            val social: Social?,
            @SerializedName("total_collections")
            val totalCollections: Int?, // 18
            @SerializedName("total_likes")
            val totalLikes: Int?, // 16104
            @SerializedName("total_photos")
            val totalPhotos: Int?, // 29
            @SerializedName("twitter_username")
            val twitterUsername: String?, // unsplash
            @SerializedName("updated_at")
            val updatedAt: String?, // 2023-10-27T05:32:01Z
            @SerializedName("username")
            val username: String?, // unsplash
        ) {
            data class Links(
                @SerializedName("followers")
                val followers: String?, // https://api.unsplash.com/users/unsplash/followers
                @SerializedName("following")
                val following: String?, // https://api.unsplash.com/users/unsplash/following
                @SerializedName("html")
                val html: String?, // https://unsplash.com/@unsplash
                @SerializedName("likes")
                val likes: String?, // https://api.unsplash.com/users/unsplash/likes
                @SerializedName("photos")
                val photos: String?, // https://api.unsplash.com/users/unsplash/photos
                @SerializedName("portfolio")
                val portfolio: String?, // https://api.unsplash.com/users/unsplash/portfolio
                @SerializedName("self")
                val self: String?, // https://api.unsplash.com/users/unsplash
            )

            data class ProfileImage(
                @SerializedName("large")
                val large: String?, // https://images.unsplash.com/profile-1544707963613-16baf868f301?ixlib=rb-4.0.3&crop=faces&fit=crop&w=128&h=128
                @SerializedName("medium")
                val medium: String?, // https://images.unsplash.com/profile-1544707963613-16baf868f301?ixlib=rb-4.0.3&crop=faces&fit=crop&w=64&h=64
                @SerializedName("small")
                val small: String?, // https://images.unsplash.com/profile-1544707963613-16baf868f301?ixlib=rb-4.0.3&crop=faces&fit=crop&w=32&h=32
            )

            data class Social(
                @SerializedName("instagram_username")
                val instagramUsername: String?, // unsplash
                @SerializedName("paypal_email")
                val paypalEmail: Any?, // null
                @SerializedName("portfolio_url")
                val portfolioUrl: String?, // https://unsplash.com
                @SerializedName("twitter_username")
                val twitterUsername: String?, // unsplash
            )
        }

        data class PreviewPhoto(
            @SerializedName("blur_hash")
            val blurHash: String?, // LGBf6XoBcYf-FEo#JPS6rpoz,vNX
            @SerializedName("created_at")
            val createdAt: String?, // 2023-06-02T00:25:18Z
            @SerializedName("id")
            val id: String?, // Qdg8WXu0yrI
            @SerializedName("slug")
            val slug: String?, // a-multicolored-abstract-background-with-curved-lines-Qdg8WXu0yrI
            @SerializedName("updated_at")
            val updatedAt: String?, // 2023-10-30T09:38:28Z
            @SerializedName("urls")
            val urls: Urls?,
        ) {
            data class Urls(
                @SerializedName("full")
                val full: String?, // https://images.unsplash.com/photo-1685665509769-3a907848565f?ixlib=rb-4.0.3&q=85&fm=jpg&crop=entropy&cs=srgb
                @SerializedName("raw")
                val raw: String?, // https://images.unsplash.com/photo-1685665509769-3a907848565f?ixlib=rb-4.0.3
                @SerializedName("regular")
                val regular: String?, // https://images.unsplash.com/photo-1685665509769-3a907848565f?ixlib=rb-4.0.3&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&fit=max
                @SerializedName("small")
                val small: String?, // https://images.unsplash.com/photo-1685665509769-3a907848565f?ixlib=rb-4.0.3&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=400&fit=max
                @SerializedName("small_s3")
                val smallS3: String?, // https://s3.us-west-2.amazonaws.com/images.unsplash.com/small/photo-1685665509769-3a907848565f
                @SerializedName("thumb")
                val thumb: String?, // https://images.unsplash.com/photo-1685665509769-3a907848565f?ixlib=rb-4.0.3&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=200&fit=max
            )
        }
    }
}
