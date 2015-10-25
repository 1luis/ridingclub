

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



app.service('memberService', ['$http', function ($http) {
    this.listMembers = function(){
        return $http.get('rest/members');
    }
}]);


app.controller('NewMemberController' , ['$scope', 'newMemberService' ,function ($scope, newMemberService){


    function MemberRequest($scope) {
        $scope.MemberRequest = {
            name: "Marc",
            surname: "Reiniking",
            city: "Elmshorn",
            address: "Bla bla bla 12",
            zipcode: "12343",
            birthday: "2010-10-11",
            entry_date: "2011-12-10",
            IBAN: "DE1234567",
            family_members: false,
            memberType: "FM"
        }

    }

    console.log($scope.MemberRequest);

    newMemberService.saveMember($scope.MemberRequest)
        .success()
        .error(function () {
            alert('Error ocurred while loading members list')
        });


}]);



app.service('newMemberService', ['$http', function ($http) {
    this.saveMember = function(){
        return $http.put('rest/members');
    }
}]);




