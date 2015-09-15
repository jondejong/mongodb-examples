(function() {
  'use strict';

  angular
    .module('ui')
    .config(routeConfig);

  /** @ngInject */
  function routeConfig($stateProvider, $urlRouterProvider) {
    $stateProvider
        .state('home', {
          url: '/home',
          templateUrl: 'app/main/main.html',
          controller: 'MainCtrl',
          controllerAs: 'mainCtrl'
        }).state('home.dogs', {
          url: '/dogs',
          templateUrl: 'app/components/dog-list/dog-list.html',
          controller: 'DogListCtrl',
          controllerAs: 'dogListCtrl'
        }).state('home.new', {
          url: '/new',
          templateUrl: 'app/components/add-dog/add-dog.html',
          controller: 'AddDogCtrl',
          controllerAs: 'addDogCtrl'
        }).state('home.edit', {
          url: '/edit/:id',
          templateUrl: 'app/components/edit-dog/edit-dog.html',
          controller: 'EditDogCtrl',
          controllerAs: 'editDogCtrl'
        });

    $urlRouterProvider.otherwise('/home/dogs');
  }

})();
