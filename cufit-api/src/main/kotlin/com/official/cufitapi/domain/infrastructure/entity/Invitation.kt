package com.official.cufitapi.domain.infrastructure.entity

import com.official.cufitapi.domain.enums.MatchMakerCandidateRelationType
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

/*
   초대 Table
 */
@Entity
class Invitation(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    /*
    초대 code
    */
    val code: String,
    /*
    초대하는 사람과의 관계
    */
    val relationType: MatchMakerCandidateRelationType,
    /*
    초대하는 사용자 ID
    */
    val memberId: Long,
    /*
    사용 여부
    : 초대코드는 사용되면, 삭제 되어야하지만 이후에 추적을 위해서, Soft Delete
    */
    var isActivated: Boolean = true

) : BaseTimeEntity() {



}