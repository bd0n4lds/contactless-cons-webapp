/*
 * Contactless Cons WebApp by Brian Donaldson
 * Copyright (c) 2020.  Brian Donaldson
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.tenderretail.webapp.controllers;

import com.tenderretail.api.domain.Name;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ServerWebExchange;


@Slf4j
@Controller
public class OptInController {

    @PostMapping("/submit")
    public String formPost(Model model, ServerWebExchange serverWebExchange) {

        MultiValueMap<String, String> map = serverWebExchange.getFormData().block();
        Name name = new Name();
        String fullName = new String(map.get("fullName").get(0));
        String email = new String(map.get("email").get(0));
        String phone = new String(map.get("phone").get(0));
        name.setFirstName(fullName);

        //model.addAttribute("user", apiService.create(new User(name, email, phone)));

        return "submit";
    }
}