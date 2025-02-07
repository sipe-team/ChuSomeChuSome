package com.official.cufitapi.domain.application

import com.official.cufitapi.domain.api.dto.notification.NotificationResponse
import com.official.cufitapi.domain.infrastructure.repository.NotificationJpaRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class NotificationService(
    private val notificationJpaRepository: NotificationJpaRepository
) {

    fun findAll(memberId : Long) : List<NotificationResponse> {
        // 알람 최신순으로 정렬
        return notificationJpaRepository.findAllByMemberIdOrderByCreatedDateDesc(memberId)
            .map {
                NotificationResponse(
                    id = it.id!!,
                    title = it.title,
                    content = it.content,
                    notificationType = it.notificationType,
                    createdDate = it.createdDate!!
                )
            }
    }

    fun save() {
        
    }
}