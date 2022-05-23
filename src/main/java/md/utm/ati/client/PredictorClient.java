package md.utm.ati.client;

import feign.Headers;
import feign.RequestLine;
import md.utm.ati.client.view.HeartFullRequestView;
import md.utm.ati.client.view.HeartFullResponseView;
import md.utm.ati.client.view.HeartPartialRequestView;
import md.utm.ati.client.view.HeartPartialResponseView;

public interface PredictorClient {

    @Headers("Content-Type: application/json")
    @RequestLine("POST /heartfull")
    HeartFullResponseView heartfull(HeartFullRequestView payload);

    @Headers("Content-Type: application/json")
    @RequestLine("POST /heartpartial")
    HeartPartialResponseView heartpartial(HeartPartialRequestView payload);

}
