/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


userApp.directive('imageCropper', function () {
    return {
        restrict: 'E',
        scope: {
            centerOnInit: '@',
            checkCrossOrigin: '@',
            cropCallback: '&',
            api: '&',
            fitOnInit: '@',
            height: '@',
            imageUrl: '@',
            showControls: '@',
            width: '@',
            zoomStep: '@',
            actionLabels: '&'
        },
        bindToController: true,
        controllerAs: 'vm',
        controller: function () {
            var self = this;

            // Get action labels.
            this.actionLabels = this.actionLabels();

            // Get callback.
            this.apiCallback = this.api();
            this.cropCallback = this.cropCallback();

            // Eval for boolean values.
            this.fitOnInit = eval(this.fitOnInit);
            this.centerOnInit = eval(this.centerOnInit);
            this.checkCrossOrigin = eval(this.checkCrossOrigin);
            this.showControls = eval(this.showControls);

            this.init = function () {
                this.target = this.element;
                this.api = new Cropper(self);
            }
        },
        'link': function (scope, element, attributes, controller) {
            controller.element = element[0];
            controller.init();
        }
    };
});
