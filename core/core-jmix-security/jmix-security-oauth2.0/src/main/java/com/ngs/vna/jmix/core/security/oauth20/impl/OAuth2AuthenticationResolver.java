/*
 * Copyright 2020 Haulmont.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ngs.vna.jmix.core.security.oauth20.impl;

import io.jmix.core.security.AuthenticationResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Component;

@Component("sec_OAuth2AuthenticationResolver")
public class OAuth2AuthenticationResolver implements AuthenticationResolver {
    @Override
    public boolean supports(Authentication authentication) {
        return authentication instanceof OAuth2Authentication;
    }

    @Override
    public Authentication resolveAuthentication(Authentication authentication) {
        return ((OAuth2Authentication) authentication).getUserAuthentication();
    }
}
