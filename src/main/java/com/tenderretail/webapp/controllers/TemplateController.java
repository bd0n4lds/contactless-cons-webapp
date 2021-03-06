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

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class TemplateController {

    @GetMapping({"about"})
    public String getAbout() {
        return "about";
    }

    @GetMapping({"dashboard"})
    public String getDashboard() {
        return "dashboard";
    }

    @GetMapping({"index"})
    public String getIndex() {
        return "index";
    }

    @GetMapping("login")
    public String getLogin() {
        return "login";
    }

    @GetMapping({"optin"})
    public String getOptin() {
        return "optin";
    }

    @GetMapping({"privacy"})
    public String getPrivacy() {
        return "privacy";
    }

    @GetMapping({"submit"})
    public String getSubmit() {
        return "submit";
    }
}