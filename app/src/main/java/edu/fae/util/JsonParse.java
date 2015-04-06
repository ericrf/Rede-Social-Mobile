package edu.fae.util;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;

/**
 * 
 * @author Robson
 *
 * @param <E>
 */
public interface JsonParse<E> {
	public E parse(JSONObject json) throws JSONException;
}
