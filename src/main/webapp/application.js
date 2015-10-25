

var app = angular.module('ridingClub', ['ngRoute']);


app.config(['$routeProvider',function($routeProvider) {


    $routeProvider.when('/Members', {
        templateUrl: "Members.html",
        controller: "MemberController"
    });

    $routeProvider.when('/Rooms',{
        templateUrl: "Rooms.html",
        controller: "RoomController"
    });

    $routeProvider.when('/createMember',{
        templateUrl: "createMember.html",
        controller: "NewMemberController"
    });

    $routeProvider.otherwise({
        redirectTo: '/Members'
    });


}]);

app.controller("MemberController", ["$scope", 'memberService', function($scope, memberService) {

    $scope.model = {
        members: []
    };

    memberService.listMembers()
        .success(function (data) {
            $scope.model.members = data;
        })
        .error(function () {
            alert('Error ocurred while loading members list')
        });

}]);

app.controller('RoomController', ['$scope', 'roomService', function ($scope, roomService) {

    // Setup scope model
    $scope.model = {
        rooms: []
    };

    // Load rooms from REST API
    roomService.listRooms()
        .success(function (data) {
            $scope.model.rooms = data;
        })
        .error(function () {
            alert('Error occured while loading');
        });

}]);


app.service('roomService', ['$http', function ($http) {

    /**
     * Return all rooms.
     * @returns {HttpPromise}
     */
    this.listRooms = function () {
        return $http.get('rest/rooms');
    }

}]);

app.service('memberService', ['$http', function ($http) {
    this.listMembers = function(){
        return $http.get('rest/members');
    }
}]);


app.controller('NewMemberController' , ['$scope', function ($scope){
    $scope.mensaje = 'hola';
}]);






