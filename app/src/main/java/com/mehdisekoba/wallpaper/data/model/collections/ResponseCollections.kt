package com.mehdisekoba.wallpaper.data.model.collections

import com.google.gson.annotations.SerializedName

class ResponseCollections : ArrayList<ResponseCollections.ResponseCollectionsItem>() {
    data class ResponseCollectionsItem(
        @SerializedName("cover_photo")
        val coverPhoto: CoverPhoto?,
        @SerializedName("description")
        val description: String?, // Bowls of soup, ramen, popcorn, acai, grains, fruits, and salads.
        @SerializedName("featured")
        val featured: Boolean?, // true
        @SerializedName("id")
        val id: String?, // DEbl-g0P1Ns
        @SerializedName("last_collected_at")
        val lastCollectedAt: String?, // 2023-10-04T12:06:48Z
        @SerializedName("links")
        val links: Links?,
        @SerializedName("preview_photos")
        val previewPhotos: List<PreviewPhoto?>?,
        @SerializedName("private")
        val `private`: Boolean?, // false
        @SerializedName("published_at")
        val publishedAt: String?, // 2023-12-12T16:43:20Z
        @SerializedName("share_key")
        val shareKey: String?, // eb9e922824aca85f031eb16183d03fe5
        @SerializedName("tags")
        val tags: List<Tag>?,
        @SerializedName("title")
        val title: String?, // We, Together
        @SerializedName("total_photos")
        val totalPhotos: Int?, // 111
        @SerializedName("updated_at")
        val updatedAt: String?, // 2023-12-12T16:43:20Z
        @SerializedName("user")
        val user: User?,
    ) {
        data class CoverPhoto(
            @SerializedName("alt_description")
            val altDescription: String?, // a couple of people standing on top of a beach next to the ocean
            @SerializedName("blur_hash")
            val blurHash: String?, // LFHn.}*_t4tS~BInT0W=n#ogflni
            @SerializedName("breadcrumbs")
            val breadcrumbs: List<Any?>?,
            @SerializedName("color")
            val color: String?, // #a68c73
            @SerializedName("created_at")
            val createdAt: String?, // 2023-09-16T01:13:41Z
            @SerializedName("current_user_collections")
            val currentUserCollections: List<Any?>?,
            @SerializedName("description")
            val description: String?, // White Rabbit in the snow
            @SerializedName("height")
            val height: Int?, // 6140
            @SerializedName("id")
            val id: String?, // VBsmC2s-cJA
            @SerializedName("liked_by_user")
            val likedByUser: Boolean?, // false
            @SerializedName("likes")
            val likes: Int?, // 139
            @SerializedName("links")
            val links: Links?,
            @SerializedName("promoted_at")
            val promotedAt: String?, // 2022-04-30T11:16:18Z
            @SerializedName("slug")
            val slug: String?, // a-couple-of-people-standing-on-top-of-a-beach-next-to-the-ocean-VBsmC2s-cJA
            @SerializedName("sponsorship")
            val sponsorship: Any?, // null
            @SerializedName("topic_submissions")
            val topicSubmissions: TopicSubmissions?,
            @SerializedName("updated_at")
            val updatedAt: String?, // 2023-12-13T23:45:31Z
            @SerializedName("urls")
            val urls: Urls?,
            @SerializedName("user")
            val user: User?,
            @SerializedName("width")
            val width: Int?, // 4386
        ) {
            data class Links(
                @SerializedName("download")
                val download: String?, // https://unsplash.com/photos/VBsmC2s-cJA/download
                @SerializedName("download_location")
                val downloadLocation: String?, // https://api.unsplash.com/photos/VBsmC2s-cJA/download
                @SerializedName("html")
                val html: String?, // https://unsplash.com/photos/a-couple-of-people-standing-on-top-of-a-beach-next-to-the-ocean-VBsmC2s-cJA
                @SerializedName("self")
                val self: String?, // https://api.unsplash.com/photos/a-couple-of-people-standing-on-top-of-a-beach-next-to-the-ocean-VBsmC2s-cJA
            )

            data class TopicSubmissions(
                @SerializedName("experimental")
                val experimental: Experimental?,
                @SerializedName("film")
                val film: Film?,
                @SerializedName("food-drink")
                val foodDrink: FoodDrink?,
                @SerializedName("health")
                val health: Health?,
                @SerializedName("nature")
                val nature: Nature?,
                @SerializedName("people")
                val people: People?,
                @SerializedName("spirituality")
                val spirituality: Spirituality?,
                @SerializedName("textures-patterns")
                val texturesPatterns: TexturesPatterns?,
                @SerializedName("travel")
                val travel: Travel?,
                @SerializedName("wallpapers")
                val wallpapers: Wallpapers?,
            ) {
                data class Experimental(
                    @SerializedName("status")
                    val status: String?, // unevaluated
                )

                data class Film(
                    @SerializedName("status")
                    val status: String?, // rejected
                )

                data class FoodDrink(
                    @SerializedName("status")
                    val status: String?, // rejected
                )

                data class Health(
                    @SerializedName("status")
                    val status: String?, // unevaluated
                )

                data class Nature(
                    @SerializedName("status")
                    val status: String?, // rejected
                )

                data class People(
                    @SerializedName("approved_on")
                    val approvedOn: String?, // 2023-11-01T14:37:49Z
                    @SerializedName("status")
                    val status: String?, // approved
                )

                data class Spirituality(
                    @SerializedName("status")
                    val status: String?, // unevaluated
                )

                data class TexturesPatterns(
                    @SerializedName("status")
                    val status: String?, // unevaluated
                )

                data class Travel(
                    @SerializedName("approved_on")
                    val approvedOn: String?, // 2023-10-19T14:00:26Z
                    @SerializedName("status")
                    val status: String?, // approved
                )

                data class Wallpapers(
                    @SerializedName("approved_on")
                    val approvedOn: String?, // 2023-09-22T08:44:58Z
                    @SerializedName("status")
                    val status: String?, // approved
                )
            }

            data class Urls(
                @SerializedName("full")
                val full: String?, // https://images.unsplash.com/photo-1694823917926-a47f7efd7807?ixlib=rb-4.0.3&q=85&fm=jpg&crop=entropy&cs=srgb
                @SerializedName("raw")
                val raw: String?, // https://images.unsplash.com/photo-1694823917926-a47f7efd7807?ixlib=rb-4.0.3
                @SerializedName("regular")
                val regular: String?, // https://images.unsplash.com/photo-1694823917926-a47f7efd7807?ixlib=rb-4.0.3&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&fit=max
                @SerializedName("small")
                val small: String?, // https://images.unsplash.com/photo-1694823917926-a47f7efd7807?ixlib=rb-4.0.3&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=400&fit=max
                @SerializedName("small_s3")
                val smallS3: String?, // https://s3.us-west-2.amazonaws.com/images.unsplash.com/small/photo-1694823917926-a47f7efd7807
                @SerializedName("thumb")
                val thumb: String?, // https://images.unsplash.com/photo-1694823917926-a47f7efd7807?ixlib=rb-4.0.3&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=200&fit=max
            )

            data class User(
                @SerializedName("accepted_tos")
                val acceptedTos: Boolean?, // true
                @SerializedName("bio")
                val bio: String?, // I'm a Caribbean-based photographer and artist, focusing on capturing the raw beauty of my homeland through my iPhone and drone. I'm passionate about creating new and exciting ways to share my art with the world.
                @SerializedName("first_name")
                val firstName: String?, // Victor
                @SerializedName("for_hire")
                val forHire: Boolean?, // false
                @SerializedName("id")
                val id: String?, // Vo2vaROlkIY
                @SerializedName("instagram_username")
                val instagramUsername: String?, // vr.victorrosario
                @SerializedName("last_name")
                val lastName: String?, // Rosario
                @SerializedName("links")
                val links: Links?,
                @SerializedName("location")
                val location: String?, // Dominican Republic
                @SerializedName("name")
                val name: String?, // Victor Rosario
                @SerializedName("portfolio_url")
                val portfolioUrl: String?, // http://instagram.com/vrrosario
                @SerializedName("profile_image")
                val profileImage: ProfileImage?,
                @SerializedName("social")
                val social: Social?,
                @SerializedName("total_collections")
                val totalCollections: Int?, // 6
                @SerializedName("total_likes")
                val totalLikes: Int?, // 316
                @SerializedName("total_photos")
                val totalPhotos: Int?, // 154
                @SerializedName("total_promoted_photos")
                val totalPromotedPhotos: Int?, // 31
                @SerializedName("twitter_username")
                val twitterUsername: String?, // VrVictorRosario
                @SerializedName("updated_at")
                val updatedAt: String?, // 2023-12-12T12:53:17Z
                @SerializedName("username")
                val username: String?, // vrrosario
            ) {
                data class Links(
                    @SerializedName("followers")
                    val followers: String?, // https://api.unsplash.com/users/vrrosario/followers
                    @SerializedName("following")
                    val following: String?, // https://api.unsplash.com/users/vrrosario/following
                    @SerializedName("html")
                    val html: String?, // https://unsplash.com/@vrrosario
                    @SerializedName("likes")
                    val likes: String?, // https://api.unsplash.com/users/vrrosario/likes
                    @SerializedName("photos")
                    val photos: String?, // https://api.unsplash.com/users/vrrosario/photos
                    @SerializedName("portfolio")
                    val portfolio: String?, // https://api.unsplash.com/users/vrrosario/portfolio
                    @SerializedName("self")
                    val self: String?, // https://api.unsplash.com/users/vrrosario
                )

                data class ProfileImage(
                    @SerializedName("large")
                    val large: String?, // https://images.unsplash.com/profile-1673549329853-4c1a89707ebcimage?ixlib=rb-4.0.3&crop=faces&fit=crop&w=128&h=128
                    @SerializedName("medium")
                    val medium: String?, // https://images.unsplash.com/profile-1673549329853-4c1a89707ebcimage?ixlib=rb-4.0.3&crop=faces&fit=crop&w=64&h=64
                    @SerializedName("small")
                    val small: String?, // https://images.unsplash.com/profile-1673549329853-4c1a89707ebcimage?ixlib=rb-4.0.3&crop=faces&fit=crop&w=32&h=32
                )

                data class Social(
                    @SerializedName("instagram_username")
                    val instagramUsername: String?, // vr.victorrosario
                    @SerializedName("paypal_email")
                    val paypalEmail: Any?, // null
                    @SerializedName("portfolio_url")
                    val portfolioUrl: String?, // http://instagram.com/vrrosario
                    @SerializedName("twitter_username")
                    val twitterUsername: String?, // VrVictorRosario
                )
            }
        }

        data class Links(
            @SerializedName("html")
            val html: String?, // https://unsplash.com/collections/DEbl-g0P1Ns/we-together
            @SerializedName("photos")
            val photos: String?, // https://api.unsplash.com/collections/DEbl-g0P1Ns/photos
            @SerializedName("related")
            val related: String?, // https://api.unsplash.com/collections/DEbl-g0P1Ns/related
            @SerializedName("self")
            val self: String?, // https://api.unsplash.com/collections/DEbl-g0P1Ns
        )

        data class PreviewPhoto(
            @SerializedName("blur_hash")
            val blurHash: String?, // LFHn.}*_t4tS~BInT0W=n#ogflni
            @SerializedName("created_at")
            val createdAt: String?, // 2023-09-16T01:13:41Z
            @SerializedName("id")
            val id: String?, // VBsmC2s-cJA
            @SerializedName("slug")
            val slug: String?, // a-couple-of-people-standing-on-top-of-a-beach-next-to-the-ocean-VBsmC2s-cJA
            @SerializedName("updated_at")
            val updatedAt: String?, // 2023-12-13T23:45:31Z
            @SerializedName("urls")
            val urls: Urls?,
        ) {
            data class Urls(
                @SerializedName("full")
                val full: String?, // https://images.unsplash.com/photo-1694823917926-a47f7efd7807?ixlib=rb-4.0.3&q=85&fm=jpg&crop=entropy&cs=srgb
                @SerializedName("raw")
                val raw: String?, // https://images.unsplash.com/photo-1694823917926-a47f7efd7807?ixlib=rb-4.0.3
                @SerializedName("regular")
                val regular: String?, // https://images.unsplash.com/photo-1694823917926-a47f7efd7807?ixlib=rb-4.0.3&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&fit=max
                @SerializedName("small")
                val small: String?, // https://images.unsplash.com/photo-1694823917926-a47f7efd7807?ixlib=rb-4.0.3&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=400&fit=max
                @SerializedName("small_s3")
                val smallS3: String?, // https://s3.us-west-2.amazonaws.com/images.unsplash.com/small/photo-1694823917926-a47f7efd7807
                @SerializedName("thumb")
                val thumb: String?, // https://images.unsplash.com/photo-1694823917926-a47f7efd7807?ixlib=rb-4.0.3&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=200&fit=max
            )
        }

        data class Tag(
            @SerializedName("source")
            val source: Source?,
            @SerializedName("title")
            val title: String?, // human
            @SerializedName("type")
            val type: String?, // search
        ) {
            data class Source(
                @SerializedName("ancestry")
                val ancestry: Ancestry?,
                @SerializedName("cover_photo")
                val coverPhoto: CoverPhoto?,
                @SerializedName("description")
                val description: String?, // Human faces speak to us in a way that language cannot. Everyone recognize a smile, a frown, tears. Unsplash has the finest selection of people images on the web: high-def and curated for quality. Family, friends, men, women, Unsplash has photos for all.
                @SerializedName("meta_description")
                val metaDescription: String?, // Choose from hundreds of free people pictures. Download HD people photos for free on Unsplash.
                @SerializedName("meta_title")
                val metaTitle: String?, // People Pictures [HQ] | Download Free Images on Unsplash
                @SerializedName("subtitle")
                val subtitle: String?, // Download free people images
                @SerializedName("title")
                val title: String?, // People images & pictures
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
                        val prettySlug: String?, // People
                        @SerializedName("slug")
                        val slug: String?, // people
                    )

                    data class Subcategory(
                        @SerializedName("pretty_slug")
                        val prettySlug: String?, // Grey
                        @SerializedName("slug")
                        val slug: String?, // grey
                    )

                    data class Type(
                        @SerializedName("pretty_slug")
                        val prettySlug: String?, // Images
                        @SerializedName("slug")
                        val slug: String?, // images
                    )
                }

                data class CoverPhoto(
                    @SerializedName("alt_description")
                    val altDescription: String?, // woman carrying baby while walking
                    @SerializedName("blur_hash")
                    val blurHash: String?, // LjI=x%:QUbv#NHWVa}kCt7jFjZfQ
                    @SerializedName("breadcrumbs")
                    val breadcrumbs: List<Breadcrumb?>?,
                    @SerializedName("color")
                    val color: String?, // #a6d9d9
                    @SerializedName("created_at")
                    val createdAt: String?, // 2017-04-20T22:04:07Z
                    @SerializedName("current_user_collections")
                    val currentUserCollections: List<Any?>?,
                    @SerializedName("description")
                    val description: String?, // Summer in France with baby
                    @SerializedName("height")
                    val height: Int?, // 3087
                    @SerializedName("id")
                    val id: String?, // PmNjS6b3XP4
                    @SerializedName("liked_by_user")
                    val likedByUser: Boolean?, // false
                    @SerializedName("likes")
                    val likes: Int?, // 2758
                    @SerializedName("links")
                    val links: Links?,
                    @SerializedName("plus")
                    val plus: Boolean?, // false
                    @SerializedName("premium")
                    val premium: Boolean?, // false
                    @SerializedName("promoted_at")
                    val promotedAt: String?, // 2017-04-21T16:00:49Z
                    @SerializedName("slug")
                    val slug: String?, // woman-carrying-baby-while-walking-PmNjS6b3XP4
                    @SerializedName("sponsorship")
                    val sponsorship: Any?, // null
                    @SerializedName("topic_submissions")
                    val topicSubmissions: TopicSubmissions?,
                    @SerializedName("updated_at")
                    val updatedAt: String?, // 2023-12-06T07:01:36Z
                    @SerializedName("urls")
                    val urls: Urls?,
                    @SerializedName("user")
                    val user: User?,
                    @SerializedName("width")
                    val width: Int?, // 4630
                ) {
                    data class Breadcrumb(
                        @SerializedName("index")
                        val index: Int?, // 0
                        @SerializedName("slug")
                        val slug: String?, // images
                        @SerializedName("title")
                        val title: String?, // 1,000,000+ Free Images
                        @SerializedName("type")
                        val type: String?, // landing_page
                    )

                    data class Links(
                        @SerializedName("download")
                        val download: String?, // https://unsplash.com/photos/PmNjS6b3XP4/download
                        @SerializedName("download_location")
                        val downloadLocation: String?, // https://api.unsplash.com/photos/PmNjS6b3XP4/download
                        @SerializedName("html")
                        val html: String?, // https://unsplash.com/photos/woman-carrying-baby-while-walking-PmNjS6b3XP4
                        @SerializedName("self")
                        val self: String?, // https://api.unsplash.com/photos/woman-carrying-baby-while-walking-PmNjS6b3XP4
                    )

                    data class TopicSubmissions(
                        @SerializedName("architecture-interior")
                        val architectureInterior: ArchitectureInterior?,
                        @SerializedName("color-of-water")
                        val colorOfWater: ColorOfWater?,
                        @SerializedName("current-events")
                        val currentEvents: CurrentEvents?,
                        @SerializedName("health")
                        val health: Health?,
                        @SerializedName("nature")
                        val nature: Nature?,
                        @SerializedName("people")
                        val people: People?,
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
                            val approvedOn: String?, // 2022-04-05T18:44:58Z
                            @SerializedName("status")
                            val status: String?, // approved
                        )

                        data class CurrentEvents(
                            @SerializedName("approved_on")
                            val approvedOn: String?, // 2021-03-01T12:52:57Z
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

                        data class People(
                            @SerializedName("approved_on")
                            val approvedOn: String?, // 2020-04-06T14:20:24Z
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
                            val approvedOn: String?, // 2021-11-16T09:10:48Z
                            @SerializedName("status")
                            val status: String?, // approved
                        )
                    }

                    data class Urls(
                        @SerializedName("full")
                        val full: String?, // https://images.unsplash.com/photo-1492725764893-90b379c2b6e7?ixlib=rb-4.0.3&q=85&fm=jpg&crop=entropy&cs=srgb
                        @SerializedName("raw")
                        val raw: String?, // https://images.unsplash.com/photo-1492725764893-90b379c2b6e7?ixlib=rb-4.0.3
                        @SerializedName("regular")
                        val regular: String?, // https://images.unsplash.com/photo-1492725764893-90b379c2b6e7?ixlib=rb-4.0.3&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&fit=max
                        @SerializedName("small")
                        val small: String?, // https://images.unsplash.com/photo-1492725764893-90b379c2b6e7?ixlib=rb-4.0.3&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=400&fit=max
                        @SerializedName("small_s3")
                        val smallS3: String?, // https://s3.us-west-2.amazonaws.com/images.unsplash.com/small/photo-1492725764893-90b379c2b6e7
                        @SerializedName("thumb")
                        val thumb: String?, // https://images.unsplash.com/photo-1492725764893-90b379c2b6e7?ixlib=rb-4.0.3&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=200&fit=max
                    )

                    data class User(
                        @SerializedName("accepted_tos")
                        val acceptedTos: Boolean?, // true
                        @SerializedName("bio")
                        val bio: String?, // Husband | Father | Creator
                        @SerializedName("first_name")
                        val firstName: String?, // Dakota
                        @SerializedName("for_hire")
                        val forHire: Boolean?, // true
                        @SerializedName("id")
                        val id: String?, // 7S_pCRiCiQo
                        @SerializedName("instagram_username")
                        val instagramUsername: String?, // thedakotacorbin
                        @SerializedName("last_name")
                        val lastName: String?, // Corbin
                        @SerializedName("links")
                        val links: Links?,
                        @SerializedName("location")
                        val location: String?, // Utah, United States
                        @SerializedName("name")
                        val name: String?, // Dakota Corbin
                        @SerializedName("portfolio_url")
                        val portfolioUrl: String?, // https://www.anniespratt.com
                        @SerializedName("profile_image")
                        val profileImage: ProfileImage?,
                        @SerializedName("social")
                        val social: Social?,
                        @SerializedName("total_collections")
                        val totalCollections: Int?, // 0
                        @SerializedName("total_likes")
                        val totalLikes: Int?, // 1
                        @SerializedName("total_photos")
                        val totalPhotos: Int?, // 44
                        @SerializedName("total_promoted_photos")
                        val totalPromotedPhotos: Int?, // 17
                        @SerializedName("twitter_username")
                        val twitterUsername: String?, // thedakotacorbin
                        @SerializedName("updated_at")
                        val updatedAt: String?, // 2023-11-08T01:20:24Z
                        @SerializedName("username")
                        val username: String?, // thedakotacorbin
                    ) {
                        data class Links(
                            @SerializedName("followers")
                            val followers: String?, // https://api.unsplash.com/users/thedakotacorbin/followers
                            @SerializedName("following")
                            val following: String?, // https://api.unsplash.com/users/thedakotacorbin/following
                            @SerializedName("html")
                            val html: String?, // https://unsplash.com/@thedakotacorbin
                            @SerializedName("likes")
                            val likes: String?, // https://api.unsplash.com/users/thedakotacorbin/likes
                            @SerializedName("photos")
                            val photos: String?, // https://api.unsplash.com/users/thedakotacorbin/photos
                            @SerializedName("portfolio")
                            val portfolio: String?, // https://api.unsplash.com/users/thedakotacorbin/portfolio
                            @SerializedName("self")
                            val self: String?, // https://api.unsplash.com/users/thedakotacorbin
                        )

                        data class ProfileImage(
                            @SerializedName("large")
                            val large: String?, // https://images.unsplash.com/profile-1688334779765-edbf1229e3fa?ixlib=rb-4.0.3&crop=faces&fit=crop&w=128&h=128
                            @SerializedName("medium")
                            val medium: String?, // https://images.unsplash.com/profile-1688334779765-edbf1229e3fa?ixlib=rb-4.0.3&crop=faces&fit=crop&w=64&h=64
                            @SerializedName("small")
                            val small: String?, // https://images.unsplash.com/profile-1688334779765-edbf1229e3fa?ixlib=rb-4.0.3&crop=faces&fit=crop&w=32&h=32
                        )

                        data class Social(
                            @SerializedName("instagram_username")
                            val instagramUsername: String?, // thedakotacorbin
                            @SerializedName("paypal_email")
                            val paypalEmail: Any?, // null
                            @SerializedName("portfolio_url")
                            val portfolioUrl: String?, // https://www.anniespratt.com
                            @SerializedName("twitter_username")
                            val twitterUsername: String?, // thedakotacorbin
                        )
                    }
                }
            }
        }

        data class User(
            @SerializedName("accepted_tos")
            val acceptedTos: Boolean?, // true
            @SerializedName("bio")
            val bio: String?, // I enjoy the simple act of taking pictures, one of my greatest joys. I love uploading them here for people to utilize for their own projects. Email me, I'd love to see the final product. Also, check out the diverse collections I've curated so far.
            @SerializedName("first_name")
            val firstName: String?, // Pete
            @SerializedName("for_hire")
            val forHire: Boolean?, // true
            @SerializedName("id")
            val id: String?, // 4FXTYbATlhc
            @SerializedName("instagram_username")
            val instagramUsername: String?, // pete.alexopoulos
            @SerializedName("last_name")
            val lastName: String?, // Alexopoulos
            @SerializedName("links")
            val links: Links?,
            @SerializedName("location")
            val location: String?, // Texas
            @SerializedName("name")
            val name: String?, // Pete Alexopoulos
            @SerializedName("portfolio_url")
            val portfolioUrl: String?, // http://Instagram.com/pete.alexopoulos
            @SerializedName("profile_image")
            val profileImage: ProfileImage?,
            @SerializedName("social")
            val social: Social?,
            @SerializedName("total_collections")
            val totalCollections: Int?, // 101
            @SerializedName("total_likes")
            val totalLikes: Int?, // 397
            @SerializedName("total_photos")
            val totalPhotos: Int?, // 359
            @SerializedName("total_promoted_photos")
            val totalPromotedPhotos: Int?, // 2
            @SerializedName("twitter_username")
            val twitterUsername: String?, // Susan_Wilkinson
            @SerializedName("updated_at")
            val updatedAt: String?, // 2023-12-13T17:12:00Z
            @SerializedName("username")
            val username: String?, // pete_a
        ) {
            data class Links(
                @SerializedName("followers")
                val followers: String?, // https://api.unsplash.com/users/pete_a/followers
                @SerializedName("following")
                val following: String?, // https://api.unsplash.com/users/pete_a/following
                @SerializedName("html")
                val html: String?, // https://unsplash.com/@pete_a
                @SerializedName("likes")
                val likes: String?, // https://api.unsplash.com/users/pete_a/likes
                @SerializedName("photos")
                val photos: String?, // https://api.unsplash.com/users/pete_a/photos
                @SerializedName("portfolio")
                val portfolio: String?, // https://api.unsplash.com/users/pete_a/portfolio
                @SerializedName("self")
                val self: String?, // https://api.unsplash.com/users/pete_a
            )

            data class ProfileImage(
                @SerializedName("large")
                val large: String?, // https://images.unsplash.com/profile-1642194729684-e3cb9dadd545image?ixlib=rb-4.0.3&crop=faces&fit=crop&w=128&h=128
                @SerializedName("medium")
                val medium: String?, // https://images.unsplash.com/profile-1642194729684-e3cb9dadd545image?ixlib=rb-4.0.3&crop=faces&fit=crop&w=64&h=64
                @SerializedName("small")
                val small: String?, // https://images.unsplash.com/profile-1642194729684-e3cb9dadd545image?ixlib=rb-4.0.3&crop=faces&fit=crop&w=32&h=32
            )

            data class Social(
                @SerializedName("instagram_username")
                val instagramUsername: String?, // pete.alexopoulos
                @SerializedName("paypal_email")
                val paypalEmail: Any?, // null
                @SerializedName("portfolio_url")
                val portfolioUrl: String?, // http://Instagram.com/pete.alexopoulos
                @SerializedName("twitter_username")
                val twitterUsername: String?, // Susan_Wilkinson
            )
        }
    }
}
