/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

postApp.service('authService', ['$http', function ($http) {
        this.PushPullData = function (method, url, content) {
            return $http({
                data: content,
                url: url,
                method: method,
                headers: {'Content-Type': 'application/json'}
            });
        };
    }]);
