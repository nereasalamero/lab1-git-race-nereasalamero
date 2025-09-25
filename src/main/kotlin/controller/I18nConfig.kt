package es.unizar.webeng.hello.controller

import org.springframework.context.MessageSource
import org.springframework.context.annotation.Bean
import org.springframework.context.support.ReloadableResourceBundleMessageSource
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

class I18nConfig : WebMvcConfigurer {
    @Bean
    fun messageSource(): MessageSource {
        val ms = ReloadableResourceBundleMessageSource()
        ms.setBasename("classpath:i18n/messages")
        ms.setDefaultEncoding("UTF-8")
        return ms
    }


}

