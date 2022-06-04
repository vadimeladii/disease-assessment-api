package md.utm.ati.client;

import feign.Headers;
import feign.RequestLine;
import md.utm.ati.client.view.*;

public interface PredictorClient {

    @Headers("Content-Type: application/json")
    @RequestLine("POST /heartfull")
    HeartFullResponseView heartfull(HeartFullRequestView payload);

    @Headers("Content-Type: application/json")
    @RequestLine("POST /heartpartial")
    HeartPartialResponseView heartpartial(HeartPartialRequestView payload);

    @Headers("Content-Type: application/json")
    @RequestLine("POST /diabetes")
    DiabeteResponseView diabetes(DiabeteRequestView payload);

    @Headers("Content-Type: application/json")
    @RequestLine("POST /bodyfat")
    BodyFatResponseView bodyFat(BodyFatRequestView payload);

    @Headers("Content-Type: application/json")
    @RequestLine("POST /bodyfatpartial")
    BodyFatPartialResponseView bodyFatPartial(BodyFatPartialRequestView payload);

    @Headers("Content-Type: application/json")
    @RequestLine("POST /stress")
    StressResponseView stress(StressRequestView payload);
}
