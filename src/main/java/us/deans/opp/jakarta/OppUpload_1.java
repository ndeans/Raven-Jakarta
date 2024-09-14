package us.deans.opp.jakarta;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.deans.opp.processor.OppPost;
import us.deans.opp.processor.OppProcessor_01;
import java.util.List;

@Path("upload1")
public class OppUpload_1 {
    Logger logger = LoggerFactory.getLogger(OppUpload_1.class);
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response setPostList(List<OppPost> postList) {
        String msg = "";

        try {
            OppProcessor_01 processor = new OppProcessor_01(postList);
            processor.log();
            processor.persist();
            msg = "inserting " + postList.size() + " post records...";
            logger.info(msg);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
        return Response.ok(msg).build();
    }
}
