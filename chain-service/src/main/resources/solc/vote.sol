// SPDX-License-Identifier: UNLICENSED
pragma solidity >=0.7.0;

contract vote {
    bytes32[] public candidates;
    mapping(bytes32 => uint8) public votes;
    constructor(bytes32[] memory _candidates) public{
        candidates = _candidates;
    }

    function validate(bytes32 candidate) internal view returns(bool){
        for(uint8 i=0;i<candidates.length;i++){
            if(candidates[i] == candidate) return true;
        }
        return false;
    }

    function setVote(bytes32 candidate) public {
        votes[candidate]+=1;
    }
    function getVote(bytes32 candidate) public view returns(uint8){
        return votes[candidate];
    }

    function reset(bytes32 candidate) public {
        votes[candidate] = 0;
    }
}