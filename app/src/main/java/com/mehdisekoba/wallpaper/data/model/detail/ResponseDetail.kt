package com.mehdisekoba.wallpaper.data.model.detail

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class ResponseDetail(
    @SerializedName("alt_description")
    val altDescription: String?, // yellow and white abstract painting
    @SerializedName("blur_hash")
    val blurHash: String?, // LHTR#grAbKs+pyi]afjsbdg3adf7
    @SerializedName("breadcrumbs")
    val breadcrumbs: @RawValue List<Breadcrumb?>?,
    @SerializedName("color")
    val color: String?, // #f3f38c
    @SerializedName("created_at")
    val createdAt: String?, // 2020-12-09T11:38:19Z
    @SerializedName("current_user_collections")
    val currentUserCollections: @RawValue List<Any?>?,
    @SerializedName("description")
    val description: String?, // Yellow cotton fabric
    @SerializedName("downloads")
    val downloads: Int?, // 172359
    @SerializedName("exif")
    val exif: @RawValue Exif?,
    @SerializedName("height")
    val height: Int?, // 5192
    @SerializedName("id")
    val id: String?, // PgqsTarkZDw
    @SerializedName("liked_by_user")
    val likedByUser: Boolean?, // false
    @SerializedName("likes")
    val likes: Int?, // 387
    @SerializedName("links")
    val links: @RawValue Links?,
    @SerializedName("location")
    val location: @RawValue Location?,
    @SerializedName("meta")
    val meta: @RawValue Meta?,
    @SerializedName("promoted_at")
    val promotedAt: String?, // 2020-12-10T10:41:53Z
    @SerializedName("public_domain")
    val publicDomain: Boolean?, // false
    @SerializedName("related_collections")
    val relatedCollections: @RawValue RelatedCollections?,
    @SerializedName("slug")
    val slug: String?, // yellow-and-white-abstract-painting-PgqsTarkZDw
    @SerializedName("sponsorship")
    val sponsorship: @RawValue Any?, // null
    @SerializedName("tags")
    val tags: @RawValue List<Tag?>?,
    @SerializedName("tags_preview")
    val tagsPreview: @RawValue List<TagsPreview?>?,
    @SerializedName("topic_submissions")
    val topicSubmissions: @RawValue TopicSubmissions?,
    @SerializedName("topics")
    val topics: @RawValue List<Topic?>?,
    @SerializedName("updated_at")
    val updatedAt: String?, // 2023-11-02T11:16:08Z
    @SerializedName("urls")
    val urls: @RawValue Urls?,
    @SerializedName("user")
    val user: @RawValue User?,
    @SerializedName("views")
    val views: Int?, // 12651558
    @SerializedName("width")
    val width: Int?, // 3461
) : Parcelable {
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

    data class Exif(
        @SerializedName("aperture")
        val aperture: Any?, // null
        @SerializedName("exposure_time")
        val exposureTime: Any?, // null
        @SerializedName("focal_length")
        val focalLength: Any?, // null
        @SerializedName("iso")
        val iso: Any?, // null
        @SerializedName("make")
        val make: Any?, // null
        @SerializedName("model")
        val model: Any?, // null
        @SerializedName("name")
        val name: Any?, // null
    )

    data class Links(
        @SerializedName("download")
        val download: String?, // https://unsplash.com/photos/PgqsTarkZDw/download?ixid=M3w1MTk4Njh8MHwxfGFsbHx8fHx8fHx8fDE2OTg5MjYxNzh8
        @SerializedName("download_location")
        val downloadLocation: String?, // https://api.unsplash.com/photos/PgqsTarkZDw/download?ixid=M3w1MTk4Njh8MHwxfGFsbHx8fHx8fHx8fDE2OTg5MjYxNzh8
        @SerializedName("html")
        val html: String?, // https://unsplash.com/photos/yellow-and-white-abstract-painting-PgqsTarkZDw
        @SerializedName("self")
        val self: String?, // https://api.unsplash.com/photos/yellow-and-white-abstract-painting-PgqsTarkZDw
    )

    data class Location(
        @SerializedName("city")
        val city: @RawValue String?, // null
        @SerializedName("country")
        val country: @RawValue String?, // null
        @SerializedName("name")
        val name: @RawValue String?, // null
        @SerializedName("position")
        val position: Position?,
    ) {
        data class Position(
            @SerializedName("latitude")
            val latitude: Any?, // null
            @SerializedName("longitude")
            val longitude: Any?, // null
        )
    }

    data class Meta(
        @SerializedName("index")
        val index: Boolean?, // true
    )

    data class RelatedCollections(
        @SerializedName("results")
        val results: List<Result?>?,
        @SerializedName("total")
        val total: Int?, // 3
        @SerializedName("type")
        val type: String?, // related
    ) {
        data class Result(
            @SerializedName("cover_photo")
            val coverPhoto: CoverPhoto?,
            @SerializedName("description")
            val description: Any?, // null
            @SerializedName("featured")
            val featured: Boolean?, // false
            @SerializedName("id")
            val id: String?, // 8500597
            @SerializedName("last_collected_at")
            val lastCollectedAt: String?, // 2022-01-30T13:30:44Z
            @SerializedName("links")
            val links: Links?,
            @SerializedName("preview_photos")
            val previewPhotos: List<PreviewPhoto?>?,
            @SerializedName("private")
            val `private`: Boolean?, // false
            @SerializedName("published_at")
            val publishedAt: String?, // 2019-08-26T09:32:24Z
            @SerializedName("share_key")
            val shareKey: String?, // cb5b709b31403352618d82e9dcaae7a5
            @SerializedName("tags")
            val tags: List<Tag?>?,
            @SerializedName("title")
            val title: String?, // WOOD
            @SerializedName("total_photos")
            val totalPhotos: Int?, // 11
            @SerializedName("updated_at")
            val updatedAt: String?, // 2022-01-30T13:38:26Z
            @SerializedName("user")
            val user: User?,
        ) {
            data class CoverPhoto(
                @SerializedName("alt_description")
                val altDescription: String?, // brown and white bird on black and white bird feeder
                @SerializedName("blur_hash")
                val blurHash: String?, // LZN^e=00j[%M-;xvj[WBt7t7j[WA
                @SerializedName("breadcrumbs")
                val breadcrumbs: List<Any?>?,
                @SerializedName("color")
                val color: String?, // #d9d9d9
                @SerializedName("created_at")
                val createdAt: String?, // 2021-01-23T22:07:29Z
                @SerializedName("current_user_collections")
                val currentUserCollections: List<Any?>?,
                @SerializedName("description")
                val description: Any?, // null
                @SerializedName("height")
                val height: Int?, // 2096
                @SerializedName("id")
                val id: String?, // GmVv2VmIxlc
                @SerializedName("liked_by_user")
                val likedByUser: Boolean?, // false
                @SerializedName("likes")
                val likes: Int?, // 104
                @SerializedName("links")
                val links: Links?,
                @SerializedName("promoted_at")
                val promotedAt: String?, // 2021-01-24T13:15:03Z
                @SerializedName("slug")
                val slug: String?, // brown-and-white-bird-on-black-and-white-bird-feeder-GmVv2VmIxlc
                @SerializedName("sponsorship")
                val sponsorship: Any?, // null
                @SerializedName("topic_submissions")
                val topicSubmissions: TopicSubmissions?,
                @SerializedName("updated_at")
                val updatedAt: String?, // 2023-11-02T00:16:22Z
                @SerializedName("urls")
                val urls: Urls?,
                @SerializedName("user")
                val user: User?,
                @SerializedName("width")
                val width: Int?, // 3144
            ) {
                data class Links(
                    @SerializedName("download")
                    val download: String?, // https://unsplash.com/photos/GmVv2VmIxlc/download
                    @SerializedName("download_location")
                    val downloadLocation: String?, // https://api.unsplash.com/photos/GmVv2VmIxlc/download
                    @SerializedName("html")
                    val html: String?, // https://unsplash.com/photos/brown-and-white-bird-on-black-and-white-bird-feeder-GmVv2VmIxlc
                    @SerializedName("self")
                    val self: String?, // https://api.unsplash.com/photos/brown-and-white-bird-on-black-and-white-bird-feeder-GmVv2VmIxlc
                )

                data class TopicSubmissions(
                    @SerializedName("textures-patterns")
                    val texturesPatterns: TexturesPatterns?,
                    @SerializedName("wallpapers")
                    val wallpapers: Wallpapers?,
                ) {
                    data class TexturesPatterns(
                        @SerializedName("approved_on")
                        val approvedOn: String?, // 2020-04-06T14:20:11Z
                        @SerializedName("status")
                        val status: String?, // approved
                    )

                    data class Wallpapers(
                        @SerializedName("approved_on")
                        val approvedOn: String?, // 2021-08-16T09:21:39Z
                        @SerializedName("status")
                        val status: String?, // approved
                    )
                }

                data class Urls(
                    @SerializedName("full")
                    val full: String?, // https://images.unsplash.com/photo-1611439406454-679d236b99e9?ixlib=rb-4.0.3&q=85&fm=jpg&crop=entropy&cs=srgb
                    @SerializedName("raw")
                    val raw: String?, // https://images.unsplash.com/photo-1611439406454-679d236b99e9?ixlib=rb-4.0.3
                    @SerializedName("regular")
                    val regular: String?, // https://images.unsplash.com/photo-1611439406454-679d236b99e9?ixlib=rb-4.0.3&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&fit=max
                    @SerializedName("small")
                    val small: String?, // https://images.unsplash.com/photo-1611439406454-679d236b99e9?ixlib=rb-4.0.3&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=400&fit=max
                    @SerializedName("small_s3")
                    val smallS3: String?, // https://s3.us-west-2.amazonaws.com/images.unsplash.com/small/photo-1611439406454-679d236b99e9
                    @SerializedName("thumb")
                    val thumb: String?, // https://images.unsplash.com/photo-1611439406454-679d236b99e9?ixlib=rb-4.0.3&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=200&fit=max
                )

                data class User(
                    @SerializedName("accepted_tos")
                    val acceptedTos: Boolean?, // true
                    @SerializedName("bio")
                    val bio: String?, // Questions about how you can use the photos? help.unsplash.com/en/collections/1463188-unsplash-license 👍
                    @SerializedName("first_name")
                    val firstName: String?, // Łukasz
                    @SerializedName("for_hire")
                    val forHire: Boolean?, // true
                    @SerializedName("id")
                    val id: String?, // FrMJ4saRdxo
                    @SerializedName("instagram_username")
                    val instagramUsername: String?, // pmcze
                    @SerializedName("last_name")
                    val lastName: String?, // Rawa
                    @SerializedName("links")
                    val links: Links?,
                    @SerializedName("location")
                    val location: String?, // Poland
                    @SerializedName("name")
                    val name: String?, // Łukasz Rawa
                    @SerializedName("portfolio_url")
                    val portfolioUrl: String?, // http://paypal.me/pmcze
                    @SerializedName("profile_image")
                    val profileImage: ProfileImage?,
                    @SerializedName("social")
                    val social: Social?,
                    @SerializedName("total_collections")
                    val totalCollections: Int?, // 0
                    @SerializedName("total_likes")
                    val totalLikes: Int?, // 211
                    @SerializedName("total_photos")
                    val totalPhotos: Int?, // 100
                    @SerializedName("twitter_username")
                    val twitterUsername: String?, // pm_cze
                    @SerializedName("updated_at")
                    val updatedAt: String?, // 2023-11-02T07:46:08Z
                    @SerializedName("username")
                    val username: String?, // lukasz_rawa
                ) {
                    data class Links(
                        @SerializedName("followers")
                        val followers: String?, // https://api.unsplash.com/users/lukasz_rawa/followers
                        @SerializedName("following")
                        val following: String?, // https://api.unsplash.com/users/lukasz_rawa/following
                        @SerializedName("html")
                        val html: String?, // https://unsplash.com/@lukasz_rawa
                        @SerializedName("likes")
                        val likes: String?, // https://api.unsplash.com/users/lukasz_rawa/likes
                        @SerializedName("photos")
                        val photos: String?, // https://api.unsplash.com/users/lukasz_rawa/photos
                        @SerializedName("portfolio")
                        val portfolio: String?, // https://api.unsplash.com/users/lukasz_rawa/portfolio
                        @SerializedName("self")
                        val self: String?, // https://api.unsplash.com/users/lukasz_rawa
                    )

                    data class ProfileImage(
                        @SerializedName("large")
                        val large: String?, // https://images.unsplash.com/profile-1642847424489-0c06e71fa50dimage?ixlib=rb-4.0.3&crop=faces&fit=crop&w=128&h=128
                        @SerializedName("medium")
                        val medium: String?, // https://images.unsplash.com/profile-1642847424489-0c06e71fa50dimage?ixlib=rb-4.0.3&crop=faces&fit=crop&w=64&h=64
                        @SerializedName("small")
                        val small: String?, // https://images.unsplash.com/profile-1642847424489-0c06e71fa50dimage?ixlib=rb-4.0.3&crop=faces&fit=crop&w=32&h=32
                    )

                    data class Social(
                        @SerializedName("instagram_username")
                        val instagramUsername: String?, // pmcze
                        @SerializedName("paypal_email")
                        val paypalEmail: Any?, // null
                        @SerializedName("portfolio_url")
                        val portfolioUrl: String?, // http://paypal.me/pmcze
                        @SerializedName("twitter_username")
                        val twitterUsername: String?, // pm_cze
                    )
                }
            }

            data class Links(
                @SerializedName("html")
                val html: String?, // https://unsplash.com/collections/8500597/wood
                @SerializedName("photos")
                val photos: String?, // https://api.unsplash.com/collections/8500597/photos
                @SerializedName("related")
                val related: String?, // https://api.unsplash.com/collections/8500597/related
                @SerializedName("self")
                val self: String?, // https://api.unsplash.com/collections/8500597
            )

            data class PreviewPhoto(
                @SerializedName("blur_hash")
                val blurHash: String?, // LZN^e=00j[%M-;xvj[WBt7t7j[WA
                @SerializedName("created_at")
                val createdAt: String?, // 2021-01-23T22:07:29Z
                @SerializedName("id")
                val id: String?, // GmVv2VmIxlc
                @SerializedName("slug")
                val slug: String?, // brown-and-white-bird-on-black-and-white-bird-feeder-GmVv2VmIxlc
                @SerializedName("updated_at")
                val updatedAt: String?, // 2023-11-02T00:16:22Z
                @SerializedName("urls")
                val urls: Urls?,
            ) {
                data class Urls(
                    @SerializedName("full")
                    val full: String?, // https://images.unsplash.com/photo-1611439406454-679d236b99e9?ixlib=rb-4.0.3&q=85&fm=jpg&crop=entropy&cs=srgb
                    @SerializedName("raw")
                    val raw: String?, // https://images.unsplash.com/photo-1611439406454-679d236b99e9?ixlib=rb-4.0.3
                    @SerializedName("regular")
                    val regular: String?, // https://images.unsplash.com/photo-1611439406454-679d236b99e9?ixlib=rb-4.0.3&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&fit=max
                    @SerializedName("small")
                    val small: String?, // https://images.unsplash.com/photo-1611439406454-679d236b99e9?ixlib=rb-4.0.3&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=400&fit=max
                    @SerializedName("small_s3")
                    val smallS3: String?, // https://s3.us-west-2.amazonaws.com/images.unsplash.com/small/photo-1611439406454-679d236b99e9
                    @SerializedName("thumb")
                    val thumb: String?, // https://images.unsplash.com/photo-1611439406454-679d236b99e9?ixlib=rb-4.0.3&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=200&fit=max
                )
            }

            data class Tag(
                @SerializedName("source")
                val source: Source?,
                @SerializedName("title")
                val title: String?, // wood
                @SerializedName("type")
                val type: String?, // landing_page
            ) {
                data class Source(
                    @SerializedName("ancestry")
                    val ancestry: Ancestry?,
                    @SerializedName("cover_photo")
                    val coverPhoto: CoverPhoto?,
                    @SerializedName("description")
                    val description: String?, // Choose from a curated selection of wood wallpapers for your mobile and desktop screens. Always free on Unsplash.
                    @SerializedName("meta_description")
                    val metaDescription: String?, // Choose from hundreds of free wood wallpapers. Download HD wallpapers for free on Unsplash.
                    @SerializedName("meta_title")
                    val metaTitle: String?, // Wood Wallpapers: Free HD Download [500+ HQ] | Unsplash
                    @SerializedName("subtitle")
                    val subtitle: String?, // Download free wood wallpapers
                    @SerializedName("title")
                    val title: String?, // Hd wood wallpapers
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
                            val prettySlug: String?, // Nature
                            @SerializedName("slug")
                            val slug: String?, // nature
                        )

                        data class Subcategory(
                            @SerializedName("pretty_slug")
                            val prettySlug: String?, // Wood
                            @SerializedName("slug")
                            val slug: String?, // wood
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
                        val altDescription: String?, // green leafed vegetable on brown wooden surface
                        @SerializedName("blur_hash")
                        val blurHash: String?, // LGNm.w^Tu3?I0c?IE0xvE0%3Inof
                        @SerializedName("breadcrumbs")
                        val breadcrumbs: List<Breadcrumb?>?,
                        @SerializedName("color")
                        val color: String?, // #d9d9d9
                        @SerializedName("created_at")
                        val createdAt: String?, // 2017-05-19T14:10:40Z
                        @SerializedName("current_user_collections")
                        val currentUserCollections: List<Any?>?,
                        @SerializedName("description")
                        val description: String?, // Fresh wood garlic on wood
                        @SerializedName("height")
                        val height: Int?, // 4069
                        @SerializedName("id")
                        val id: String?, // EWDvHNNfUmQ
                        @SerializedName("liked_by_user")
                        val likedByUser: Boolean?, // false
                        @SerializedName("likes")
                        val likes: Int?, // 3485
                        @SerializedName("links")
                        val links: Links?,
                        @SerializedName("plus")
                        val plus: Boolean?, // false
                        @SerializedName("premium")
                        val premium: Boolean?, // false
                        @SerializedName("promoted_at")
                        val promotedAt: String?, // 2017-05-20T07:44:39Z
                        @SerializedName("slug")
                        val slug: String?, // green-leafed-vegetable-on-brown-wooden-surface-EWDvHNNfUmQ
                        @SerializedName("sponsorship")
                        val sponsorship: Any?, // null
                        @SerializedName("topic_submissions")
                        val topicSubmissions: TopicSubmissions?,
                        @SerializedName("updated_at")
                        val updatedAt: String?, // 2023-10-30T09:01:19Z
                        @SerializedName("urls")
                        val urls: Urls?,
                        @SerializedName("user")
                        val user: User?,
                        @SerializedName("width")
                        val width: Int?, // 6144
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
                            val download: String?, // https://unsplash.com/photos/EWDvHNNfUmQ/download
                            @SerializedName("download_location")
                            val downloadLocation: String?, // https://api.unsplash.com/photos/EWDvHNNfUmQ/download
                            @SerializedName("html")
                            val html: String?, // https://unsplash.com/photos/green-leafed-vegetable-on-brown-wooden-surface-EWDvHNNfUmQ
                            @SerializedName("self")
                            val self: String?, // https://api.unsplash.com/photos/green-leafed-vegetable-on-brown-wooden-surface-EWDvHNNfUmQ
                        )

                        data class TopicSubmissions(
                            @SerializedName("architecture-interior")
                            val architectureInterior: ArchitectureInterior?,
                            @SerializedName("arts-culture")
                            val artsCulture: ArtsCulture?,
                            @SerializedName("color-of-water")
                            val colorOfWater: ColorOfWater?,
                            @SerializedName("nature")
                            val nature: Nature?,
                            @SerializedName("spirituality")
                            val spirituality: Spirituality?,
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

                            data class ArtsCulture(
                                @SerializedName("approved_on")
                                val approvedOn: String?, // 2020-04-06T14:20:25Z
                                @SerializedName("status")
                                val status: String?, // approved
                            )

                            data class ColorOfWater(
                                @SerializedName("approved_on")
                                val approvedOn: String?, // 2022-04-05T18:44:58Z
                                @SerializedName("status")
                                val status: String?, // approved
                            )

                            data class Nature(
                                @SerializedName("approved_on")
                                val approvedOn: String?, // 2020-04-06T14:20:12Z
                                @SerializedName("status")
                                val status: String?, // approved
                            )

                            data class Spirituality(
                                @SerializedName("approved_on")
                                val approvedOn: String?, // 2020-04-06T14:20:22Z
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
                            val full: String?, // https://images.unsplash.com/photo-1495195129352-aeb325a55b65?ixlib=rb-4.0.3&q=85&fm=jpg&crop=entropy&cs=srgb
                            @SerializedName("raw")
                            val raw: String?, // https://images.unsplash.com/photo-1495195129352-aeb325a55b65?ixlib=rb-4.0.3
                            @SerializedName("regular")
                            val regular: String?, // https://images.unsplash.com/photo-1495195129352-aeb325a55b65?ixlib=rb-4.0.3&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&fit=max
                            @SerializedName("small")
                            val small: String?, // https://images.unsplash.com/photo-1495195129352-aeb325a55b65?ixlib=rb-4.0.3&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=400&fit=max
                            @SerializedName("small_s3")
                            val smallS3: String?, // https://s3.us-west-2.amazonaws.com/images.unsplash.com/small/photo-1495195129352-aeb325a55b65
                            @SerializedName("thumb")
                            val thumb: String?, // https://images.unsplash.com/photo-1495195129352-aeb325a55b65?ixlib=rb-4.0.3&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=200&fit=max
                        )

                        data class User(
                            @SerializedName("accepted_tos")
                            val acceptedTos: Boolean?, // false
                            @SerializedName("bio")
                            val bio: String?, // Help me bring you more photos by any Paypal donate :-)
                            @SerializedName("first_name")
                            val firstName: String?, // Lukas
                            @SerializedName("for_hire")
                            val forHire: Boolean?, // false
                            @SerializedName("id")
                            val id: String?, // kJVLfz8wBt8
                            @SerializedName("instagram_username")
                            val instagramUsername: String?, // joshboot
                            @SerializedName("last_name")
                            val lastName: String?, // Blazek
                            @SerializedName("links")
                            val links: Links?,
                            @SerializedName("location")
                            val location: String?, // Czech republic
                            @SerializedName("name")
                            val name: String?, // Lukas Blazek
                            @SerializedName("portfolio_url")
                            val portfolioUrl: String?, // https://www.paypal.me/goumbik
                            @SerializedName("profile_image")
                            val profileImage: ProfileImage?,
                            @SerializedName("social")
                            val social: Social?,
                            @SerializedName("total_collections")
                            val totalCollections: Int?, // 0
                            @SerializedName("total_likes")
                            val totalLikes: Int?, // 0
                            @SerializedName("total_photos")
                            val totalPhotos: Int?, // 31
                            @SerializedName("twitter_username")
                            val twitterUsername: String?, // joshboot_
                            @SerializedName("updated_at")
                            val updatedAt: String?, // 2023-09-18T10:59:26Z
                            @SerializedName("username")
                            val username: String?, // goumbik
                        ) {
                            data class Links(
                                @SerializedName("followers")
                                val followers: String?, // https://api.unsplash.com/users/goumbik/followers
                                @SerializedName("following")
                                val following: String?, // https://api.unsplash.com/users/goumbik/following
                                @SerializedName("html")
                                val html: String?, // https://unsplash.com/@goumbik
                                @SerializedName("likes")
                                val likes: String?, // https://api.unsplash.com/users/goumbik/likes
                                @SerializedName("photos")
                                val photos: String?, // https://api.unsplash.com/users/goumbik/photos
                                @SerializedName("portfolio")
                                val portfolio: String?, // https://api.unsplash.com/users/goumbik/portfolio
                                @SerializedName("self")
                                val self: String?, // https://api.unsplash.com/users/goumbik
                            )

                            data class ProfileImage(
                                @SerializedName("large")
                                val large: String?, // https://images.unsplash.com/profile-1494586455964-faceafd44a6f?ixlib=rb-4.0.3&crop=faces&fit=crop&w=128&h=128
                                @SerializedName("medium")
                                val medium: String?, // https://images.unsplash.com/profile-1494586455964-faceafd44a6f?ixlib=rb-4.0.3&crop=faces&fit=crop&w=64&h=64
                                @SerializedName("small")
                                val small: String?, // https://images.unsplash.com/profile-1494586455964-faceafd44a6f?ixlib=rb-4.0.3&crop=faces&fit=crop&w=32&h=32
                            )

                            data class Social(
                                @SerializedName("instagram_username")
                                val instagramUsername: String?, // joshboot
                                @SerializedName("paypal_email")
                                val paypalEmail: Any?, // null
                                @SerializedName("portfolio_url")
                                val portfolioUrl: String?, // https://www.paypal.me/goumbik
                                @SerializedName("twitter_username")
                                val twitterUsername: String?, // joshboot_
                            )
                        }
                    }
                }
            }

            data class User(
                @SerializedName("accepted_tos")
                val acceptedTos: Boolean?, // false
                @SerializedName("bio")
                val bio: Any?, // null
                @SerializedName("first_name")
                val firstName: String?, // Fabian
                @SerializedName("for_hire")
                val forHire: Boolean?, // false
                @SerializedName("id")
                val id: String?, // Ivdcf-5Y228
                @SerializedName("instagram_username")
                val instagramUsername: Any?, // null
                @SerializedName("last_name")
                val lastName: String?, // Nusi
                @SerializedName("links")
                val links: Links?,
                @SerializedName("location")
                val location: Any?, // null
                @SerializedName("name")
                val name: String?, // Fabian Nusi
                @SerializedName("portfolio_url")
                val portfolioUrl: Any?, // null
                @SerializedName("profile_image")
                val profileImage: ProfileImage?,
                @SerializedName("social")
                val social: Social?,
                @SerializedName("total_collections")
                val totalCollections: Int?, // 1
                @SerializedName("total_likes")
                val totalLikes: Int?, // 3
                @SerializedName("total_photos")
                val totalPhotos: Int?, // 0
                @SerializedName("twitter_username")
                val twitterUsername: Any?, // null
                @SerializedName("updated_at")
                val updatedAt: String?, // 2023-03-25T19:23:45Z
                @SerializedName("username")
                val username: String?, // fab2104
            ) {
                data class Links(
                    @SerializedName("followers")
                    val followers: String?, // https://api.unsplash.com/users/fab2104/followers
                    @SerializedName("following")
                    val following: String?, // https://api.unsplash.com/users/fab2104/following
                    @SerializedName("html")
                    val html: String?, // https://unsplash.com/@fab2104
                    @SerializedName("likes")
                    val likes: String?, // https://api.unsplash.com/users/fab2104/likes
                    @SerializedName("photos")
                    val photos: String?, // https://api.unsplash.com/users/fab2104/photos
                    @SerializedName("portfolio")
                    val portfolio: String?, // https://api.unsplash.com/users/fab2104/portfolio
                    @SerializedName("self")
                    val self: String?, // https://api.unsplash.com/users/fab2104
                )

                data class ProfileImage(
                    @SerializedName("large")
                    val large: String?, // https://images.unsplash.com/profile-fb-1552411352-df7136a3ad86.jpg?ixlib=rb-4.0.3&crop=faces&fit=crop&w=128&h=128
                    @SerializedName("medium")
                    val medium: String?, // https://images.unsplash.com/profile-fb-1552411352-df7136a3ad86.jpg?ixlib=rb-4.0.3&crop=faces&fit=crop&w=64&h=64
                    @SerializedName("small")
                    val small: String?, // https://images.unsplash.com/profile-fb-1552411352-df7136a3ad86.jpg?ixlib=rb-4.0.3&crop=faces&fit=crop&w=32&h=32
                )

                data class Social(
                    @SerializedName("instagram_username")
                    val instagramUsername: Any?, // null
                    @SerializedName("paypal_email")
                    val paypalEmail: Any?, // null
                    @SerializedName("portfolio_url")
                    val portfolioUrl: Any?, // null
                    @SerializedName("twitter_username")
                    val twitterUsername: Any?, // null
                )
            }
        }
    }

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

    data class TagsPreview(
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
                    @SerializedName("textures-patterns")
                    val texturesPatterns: TexturesPatterns?,
                ) {
                    data class TexturesPatterns(
                        @SerializedName("approved_on")
                        val approvedOn: String?, // 2020-04-06T14:20:11Z
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
        @SerializedName("color-of-water")
        val colorOfWater: ColorOfWater?,
        @SerializedName("textures-patterns")
        val texturesPatterns: TexturesPatterns?,
    ) {
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

    data class Topic(
        @SerializedName("id")
        val id: String?, // iUIsnVtjB0Y
        @SerializedName("slug")
        val slug: String?, // textures-patterns
        @SerializedName("title")
        val title: String?, // Textures & Patterns
        @SerializedName("visibility")
        val visibility: String?, // featured
    )

    data class Urls(
        @SerializedName("full")
        val full: String?, // https://images.unsplash.com/photo-1607513746994-51f730a44832?crop=entropy&cs=srgb&fm=jpg&ixid=M3w1MTk4Njh8MHwxfGFsbHx8fHx8fHx8fDE2OTg5MjYxNzh8&ixlib=rb-4.0.3&q=85
        @SerializedName("raw")
        val raw: String?, // https://images.unsplash.com/photo-1607513746994-51f730a44832?ixid=M3w1MTk4Njh8MHwxfGFsbHx8fHx8fHx8fDE2OTg5MjYxNzh8&ixlib=rb-4.0.3
        @SerializedName("regular")
        val regular: String?, // https://images.unsplash.com/photo-1607513746994-51f730a44832?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3w1MTk4Njh8MHwxfGFsbHx8fHx8fHx8fDE2OTg5MjYxNzh8&ixlib=rb-4.0.3&q=80&w=1080
        @SerializedName("small")
        val small: String?, // https://images.unsplash.com/photo-1607513746994-51f730a44832?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3w1MTk4Njh8MHwxfGFsbHx8fHx8fHx8fDE2OTg5MjYxNzh8&ixlib=rb-4.0.3&q=80&w=400
        @SerializedName("small_s3")
        val smallS3: String?, // https://s3.us-west-2.amazonaws.com/images.unsplash.com/small/photo-1607513746994-51f730a44832
        @SerializedName("thumb")
        val thumb: String?, // https://images.unsplash.com/photo-1607513746994-51f730a44832?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3w1MTk4Njh8MHwxfGFsbHx8fHx8fHx8fDE2OTg5MjYxNzh8&ixlib=rb-4.0.3&q=80&w=200
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
        val portfolioUrl: Any?, // null
        @SerializedName("profile_image")
        val profileImage: ProfileImage?,
        @SerializedName("social")
        val social: Social?,
        @SerializedName("total_collections")
        val totalCollections: Int?, // 0
        @SerializedName("total_likes")
        val totalLikes: Int?, // 0
        @SerializedName("total_photos")
        val totalPhotos: Int?, // 61
        @SerializedName("twitter_username")
        val twitterUsername: Any?, // null
        @SerializedName("updated_at")
        val updatedAt: String?, // 2023-11-02T11:30:19Z
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
            val portfolioUrl: Any?, // null
            @SerializedName("twitter_username")
            val twitterUsername: Any?, // null
        )
    }
}
