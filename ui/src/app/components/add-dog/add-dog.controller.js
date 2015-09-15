'use strict';

angular.module('ui')
    .controller('AddDogCtrl', function ($http, $state, dogService) {
      var self = this;

      self.dog = {};

      self.save = function() {
        dogService.save(self.dog).then(function() {
          $state.go('home.dogs');
        });
      }
    });
