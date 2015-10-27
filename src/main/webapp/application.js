

var app = angular.module('ridingClub', ['ngRoute']);


app.config(['$routeProvider',function($routeProvider) {


    $routeProvider.when('/Members', {
        templateUrl: "Members.html",
        controller: "MemberController"
    });

    $routeProvider.when('/createMember',{
        templateUrl: "createMember.html",
        controller: "NewMemberController"
    });

    $routeProvider.when('/deleteMember',{
        templateUrl: "deleteMember.html",
        controller: "delMemberController"
    });

    $routeProvider.otherwise({
        redirectTo: '/Members'
    });


}]);

//*******************************************************************************************************
//*Shows all members in a list
//*******************************************************************************************************

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

//*******************************************************************************************************
//*Adds a new member
//*******************************************************************************************************


app.controller('NewMemberController' , ['$scope', 'newMemberService' ,function ($scope, newMemberService){


    function MemberRequest($scope) {
        $scope.MemberRequest = {
            name: "Testname",
            surname: "Testsurname",
            city: "Testcity",
            address: "Testadress",
            zipcode: "Testzipcode",
            birthday: "01-02-1904",
            entry_date: "2011-12-10",
            IBAN: "DE1234567890",
            family_members: false,
            memberType: "Jugendmitglied"
        }

    }

    newMemberService.saveMember($scope.MemberRequest)
        .success()
        .error(function () {
            alert('Error ocurred while loading members list')
        });


}]);
//TODO: Die Payload war hier leer, jetzt um 'MeberRequest' ergänzt, immernoch Fehler 415
app.service('newMemberService', ['$http', function ($http) {
    this.saveMember = function(MemberRequest)
    {
        return $http.put('rest/members', MemberRequest);
    }
}]);

//*******************************************************************************************************
//*Deletes an existing member
//*******************************************************************************************************

app.controller("delMemberController", ["$scope",'memberService', function($scope, $memberservice) {


    $scope.todelete = {
        name: "",
        surname: ""
    };

    $scope.delete = function() {


        $scope.todelete.name = "caddca";
        $scope.todelete.surname = "caddcfffffa";
    }



}]);

