

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


app.controller('NewMemberController' , ['$scope', '$http' ,function ($scope ,$http){


        $scope.model ={
            members: {
                name: "Testname",
                surname: "Testsurname",
                city: "Testcity",
                address: "Testadress",
                zipcode: "28250",
                birthday: "01-02-1904",
                entryDate: "2011-12-10",
                iban: "DE1234567890",
                familyMembers: false,
                memberType:{
                    name:"Vollmitglied",
                    amount: 25
                }
            }

};


    var config={
        method:"PUT",
        url:"http://localhost:8080/rest/member",
        data: $scope.Member
    };

    var response=$http(config);

    response.success(function(data, status, headers, config) {
        alert("Se ha añadido marc:"+status);
    });

    response.error(function(data, status, headers, config) {
        alert("Ha fallado la petición. Estado HTTP:"+status);
    });



}]);

//*******************************************************************************************************
//*Deletes an existing member
//*******************************************************************************************************

app.controller("delMemberController", ["$scope",'$log','$http', function($scope, $log, $http) {


    $scope.todelete = {
        name: "",
        surname: ""
    };

    $scope.delete = function() {
        $scope.todelete.name = "caddca";
        $scope.todelete.surname = "caddcfffffa";
    };


        var config={
            method:"DELETE",
            url:"http://localhost:8080/rest/member/"
        };

        var response=$http(config);

        response.success(function(data, status, headers, config) {
            alert("Se ha borrado el 2:"+status);
        });

        response.error(function(data, status, headers, config) {
            alert("Ha fallado la petición. Estado HTTP:"+status);
        });




}]);

