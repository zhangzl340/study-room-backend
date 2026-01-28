package com.studyroom.modules.auth.service.impl;

import com.alibaba.excel.util.StringUtils;
import com.studyroom.common.constant.RedisKeyConstant;
import com.studyroom.common.exception.BusinessException;
import com.studyroom.common.utils.RedisUtils;
import com.studyroom.modules.auth.service.CaptchaService;
import com.studyroom.common.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CaptchaServiceImpl implements CaptchaService {
    private final RedisUtils redisUtils;

    @Override
    public boolean validateCaptcha(String captchaKey, String captchaCode) {
        if (StringUtils.isBlank(captchaKey) || StringUtils.isBlank(captchaCode)) {
            throw new BusinessException(ErrorCode.CAPTCHA_ERROR);
        }

        captchaKey = RedisKeyConstant.CAPTCHA_KEY + captchaKey;
        log.error("captchaKey is " + captchaKey);
        String storedCaptcha;
        // 从Redis获取存储的验证码
        if(redisUtils.hasKey(captchaKey))
        {
            storedCaptcha = redisUtils.get(captchaKey).toString();
        }else{
            throw new BusinessException(ErrorCode.REDIS_ERROR);
        }
        // 验证码不存在或已过期
        if (storedCaptcha == null) {
            throw new BusinessException(ErrorCode.CAPTCHA_EXPIRED);
        }
        // 验证码不区分大小写比较（根据需求调整）
        if (!storedCaptcha.equalsIgnoreCase(captchaCode.trim())) {
            throw new BusinessException(ErrorCode.CAPTCHA_ERROR);
        }
        // 验证成功后，删除Redis中的验证码，防止重复使用
        redisUtils.delete(RedisKeyConstant.CAPTCHA_KEY + captchaKey);
        log.debug("验证码验证成功: key={}, code={}", captchaKey, captchaCode);
        return true;
    }
}
