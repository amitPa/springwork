<%-- 
    Document   : ImageEditor
    Created on : Sep 23, 2016, 7:37:49 PM
    Author     : AmitPandey
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<!DOCTYPE html>
    <head>
        <meta charset="utf-8" />
        <title>HTML5 image crop tool | Script Tutorials</title>
        <script src="resource/js/lib/script.js" type="text/javascript"></script>
    </head>
    <body>
        <div class="container">
            <h2>Upload image crop Image</h2>
            <div class="contr">
                <button onclick="getResults()">Crop</button>
                <input type="file" onchange="upload(this)" >
                <button onclick="save()">Save</button>
                 <img id="blah" src="#" alt="your image" />
            </div>
            <canvas id="panel" width="800" height="800"></canvas>
            <div id="results">
                <h2>Please make selection for cropping and click 'Crop' button.</h2>
                
                <img id="crop_result" />
                
            </div>
        </div>

