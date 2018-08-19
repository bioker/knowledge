import grpc
import test_pb2
import test_pb2_grpc

channel = grpc.insecure_channel("localhost:8080")
stub = test_pb2_grpc.GreeterStub(channel)
stub.greet(test_pb2.Greeting(name="Python"))
