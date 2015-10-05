'use strict';

angular.module('ui')
    .controller('EditDogCtrl', function ($http, $state, $stateParams, dogService) {
      var self = this;

      self.dog = {};

      dogService.get($stateParams.id).then(function(dog) {
        self.dog = dog;
      });

      self.save = function() {
        dogService.update(self.dog).then(function() {
          $state.go('home.dogs');
        });
      };

      self.cancel = function() {
        $state.go('home.dogs');
      };

    });
