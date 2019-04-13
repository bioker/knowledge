import json
from flask import Flask, request, abort
import time

app = Flask(__name__)

events = {}

@app.route("/event", methods=['POST'])
def create_event():
    if request.json:
        event_id = int(round(time.time() * 1000))
        events[str(event_id)] = request.json
        return str(event_id)
    else:
        abort(400)

@app.route("/event/<event_id>", methods=['GET'])
@app.route("/event")
def get_event(event_id=None):
    if event_id:
        return json.dumps(events[event_id])
    else:
        return json.dumps(events.keys())

@app.route("/events", methods=['GET'])
def get_events():
    return json.dumps(events)

@app.route("/event/<event_id>", methods=['PUT'])
def update_event(event_id):
    if request.json:
        events[event_id] = request.json
    else:
        abort(400)
    return ('', 204)

@app.route("/event/<event_id>", methods=['DELETE'])
def delete_event(event_id):
    del(events[event_id])
    return ('', 204)
