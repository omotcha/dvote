package org.omotcha.jcontracts;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.8.7.
 */
@SuppressWarnings("rawtypes")
public class Vote extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b506040516103203803806103208339818101604052602081101561003357600080fd5b810190808051604051939291908464010000000082111561005357600080fd5b90830190602082018581111561006857600080fd5b825186602082028301116401000000008211171561008557600080fd5b82525081516020918201928201910280838360005b838110156100b257818101518382015260200161009a565b5050505091909101604052505082516100d492506000915060208401906100db565b505061013b565b828054828255906000526020600020908101928215610116579160200282015b828111156101165782518255916020019190600101906100fb565b50610122929150610126565b5090565b5b808211156101225760008155600101610127565b6101d68061014a6000396000f3fe608060405234801561001057600080fd5b50600436106100575760003560e01c80632b38cd961461005c5780633477ee2e1461008f57806351550869146100be578063ed3c7d40146100db578063f85008a2146100fa575b600080fd5b6100796004803603602081101561007257600080fd5b5035610117565b6040805160ff9092168252519081900360200190f35b6100ac600480360360208110156100a557600080fd5b503561012c565b60408051918252519081900360200190f35b610079600480360360208110156100d457600080fd5b503561014a565b6100f8600480360360208110156100f157600080fd5b503561015f565b005b6100f86004803603602081101561011057600080fd5b5035610177565b60016020526000908152604090205460ff1681565b6000818154811061013957fe5b600091825260209091200154905081565b60009081526001602052604090205460ff1690565b6000908152600160205260409020805460ff19169055565b6000908152600160208190526040909120805460ff19811660ff9182169093011691909117905556fea264697066735822122077b1a1b8deb056ee467a54fcb8807754d250ddcfbf97123dc24d8c275e1404de64736f6c63430007010033";

    public static final String FUNC_CANDIDATES = "candidates";

    public static final String FUNC_GETVOTE = "getVote";

    public static final String FUNC_RESET = "reset";

    public static final String FUNC_SETVOTE = "setVote";

    public static final String FUNC_VOTES = "votes";

    @Deprecated
    protected Vote(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Vote(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Vote(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Vote(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<byte[]> candidates(BigInteger param0) {
        final Function function = new Function(FUNC_CANDIDATES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<BigInteger> getVote(byte[] candidate) {
        final Function function = new Function(FUNC_GETVOTE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(candidate)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> reset(byte[] candidate) {
        final Function function = new Function(
                FUNC_RESET, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(candidate)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setVote(byte[] candidate) {
        final Function function = new Function(
                FUNC_SETVOTE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(candidate)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> votes(byte[] param0) {
        final Function function = new Function(FUNC_VOTES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    @Deprecated
    public static Vote load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Vote(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Vote load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Vote(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Vote load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Vote(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Vote load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Vote(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Vote> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, List<byte[]> _candidates) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.datatypes.generated.Bytes32.class,
                        org.web3j.abi.Utils.typeMap(_candidates, org.web3j.abi.datatypes.generated.Bytes32.class))));
        return deployRemoteCall(Vote.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<Vote> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, List<byte[]> _candidates) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.datatypes.generated.Bytes32.class,
                        org.web3j.abi.Utils.typeMap(_candidates, org.web3j.abi.datatypes.generated.Bytes32.class))));
        return deployRemoteCall(Vote.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Vote> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, List<byte[]> _candidates) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.datatypes.generated.Bytes32.class,
                        org.web3j.abi.Utils.typeMap(_candidates, org.web3j.abi.datatypes.generated.Bytes32.class))));
        return deployRemoteCall(Vote.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Vote> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, List<byte[]> _candidates) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.datatypes.generated.Bytes32.class,
                        org.web3j.abi.Utils.typeMap(_candidates, org.web3j.abi.datatypes.generated.Bytes32.class))));
        return deployRemoteCall(Vote.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }
}
