from concurrent import futures
import time
import grpc
import test_pb2
import test_pb2_grpc

class Greeter(test_pb2_grpc.GreeterServicer):
    def greet(self, request, context):
        print("Hello, {0}!".format(request.name))
        return test_pb2.Empty()

server = grpc.server(futures.ThreadPoolExecutor(max_workers=10))
test_pb2_grpc.add_GreeterServicer_to_server(Greeter(), server)
server.add_insecure_port("[::]:8080")
server.start()

try:
    while True:
        time.sleep(60 * 60)
except KeyboardInterrupt:
    server.stop(0)
