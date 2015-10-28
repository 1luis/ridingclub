

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


app.controller('NewMemberController' , ['$scope',"$log", '$http' ,function ($scope, $log ,$http){


    $scope.model = {
        members: {
            name: "jsjs",
            surname: "fff",
            city: "fff",
            address: "fff",
            zipcode: "fff",
            birthday: "fff",
            entryDate: "fff",
            iban: "ffff",
            familyMembers: false,
            memberType: {
                name: "VM",
                amount: 25
            }
        }
    };


    var member=this;

    //inicializo un objeto en los datos de formulario
    member = {
            name: "jsjs",
            surname: "fff",
            city: "fff",
            address: "fff",
            zipcode: "fff",
            birthday: "11-11-2010",
            entryDate: "11-11-2010",
            iban: "ffff",
            familyMembers: false,
            memberType: {
                name: "Vollmitglied",
                amount: 25
            }
    };

    var config={
        method:"PUT",
        url:"rest/member",
        data: member
    };

    var response=$http(config);

    response.success(function(data, status, headers, config) {
        alert("Se ha borrado el 2:"+status);
    });

    response.error(function(data, status, headers, config) {
        alert("Ha fallado la petición. Estado HTTP:"+status);
    });

/*    $scope.put = function(member) {
        $http.put("http://localhost:8080/rest/member", { 'member': member })
            .success(function(result) {
            console.log(result);
            $scope.resultPut = result;
        }).error(function() {
            console.log("error");
        });
    };*/





    /*    $scope.anlegen = function() {

            $scope.model.members.name = "caddca";


            var config={
             method:"PUT",
             url:"http://localhost:8080/rest/member",
             data: $scope.model
             };

             var response=$http(config);

             response.success(function(data, status, headers, config) {
             alert("Se ha añadido marc:"+status);
             });

             response.error(function(data, status, headers, config) {
             alert("Ha fallado la petición. Estado HTTP:"+status);
             });

        };*/



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

