package ashcheulov.mr.dao;

import ashcheulov.mr.db.WhatTheHeck;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import org.hibernate.Session;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

@ApplicationScoped
public class DAO {

    @Inject
    EntityManager entityManager;

    public JsonArray getMessages() {
        JsonArray jsonArray = new JsonArray();
        TypedQuery<WhatTheHeck> typedQuery = entityManager.createQuery("SELECT p FROM WhatTheHeck p", WhatTheHeck.class);
        typedQuery.getResultList().forEach(heck -> jsonArray.add(new JsonObject()
                .put("text_message",heck.getText_message())
                .put("user_name",heck.getHeckingUsers().getUser_name())));
        return jsonArray;
    }

    public void setMessage(JsonObject message) {
        WhatTheHeck whatTheHeck = new WhatTheHeck();
        whatTheHeck.setText_message(message.getString("message"));
        whatTheHeck.setId_user(message.getInteger("user_id"));

        Session session = entityManager.unwrap(Session.class);
        session.save(whatTheHeck);
    }
}
