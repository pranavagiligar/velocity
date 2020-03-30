package com.velocity.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties
import org.springframework.boot.info.BuildProperties
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class ServerStatusController {

    @GetMapping(path = ["/server/info"])
    fun getServerInfo(): String =
        """
            <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 3.2//EN"> 
<html>
   <head>
      <title> Velocity </title>
      <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
      <meta name="author" content="Copyright 2020 Pranava G R">
      <meta name="keywords" content="Server-Eventrace">
      <meta name="description" content="Eventrace portal">
   </head>
   <body bgcolor="#ffffff" text="#000000" link="#0000ff" vlink="#800080" alink="#ff0000">
      <h1 align="center"> Welcome to Velocity System Info </h1>
      <p align="center"> The server is running healthy <br> <br> 
      See the <a href="https://github.com/pranavagiligar/velocity"> Github page </a> <br>
      And <a href="https://pranavagiligar.github.io/velocity/"> <i> Github.io for documentation </i></a>
   </body>
</html>
        """.trimIndent()
}