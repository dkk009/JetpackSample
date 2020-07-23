package com.example.androidjetpacksamples.feature.home.model

import android.os.Parcelable
import androidx.room.*
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
data class Repo(
    @PrimaryKey @SerializedName("id") val repoId: Long,
    val name: String?,
    val fullName: String?,
    val url: String?,
    @Embedded
    val owner: Owner
) : Parcelable

@Parcelize
@Entity
data class Owner(
    val login: String,
    @PrimaryKey @SerializedName("id") val ownerId: Long,
    @SerializedName("avatar_url")
    val avatar: String?,
    @SerializedName("followers_url")
    val followersUrl: String?
) : Parcelable

@Entity(primaryKeys = ["repoId", "ownerId"])
data class RepoOwnerCrossRef(
    val repoId: Long,
    val ownerId: Long
)

data class OwnerWithRepos(
    @Embedded val owner: Owner,
    @Relation(
        parentColumn = "ownerId",
        entityColumn = "repoId",
        associateBy = Junction(RepoOwnerCrossRef::class)
    )
    val repoList: List<Repo>
)

data class RepoWithOwner(
    @Embedded val repo: Repo,
    @Relation(
        parentColumn = "repoId",
        entityColumn = "ownerId",
        associateBy = Junction(RepoOwnerCrossRef::class)
    )
    val repoList: List<Owner>
)