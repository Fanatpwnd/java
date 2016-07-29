from http.server import HTTPServer, CGIHTTPRequestHandler
server_address = ("", 8000)
httpd = HTTPServer(server_address, CGIHTTPRequestHandler)
print("Serving HTTP on localhost port 8000...")
httpd.serve_forever()

