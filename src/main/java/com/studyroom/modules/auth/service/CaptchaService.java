package com.studyroom.modules.auth.service;

import com.studyroom.common.utils.RedisUtils;

public interface CaptchaService {
    boolean validateCaptcha(String captchaKey, String captchaCode);
}
