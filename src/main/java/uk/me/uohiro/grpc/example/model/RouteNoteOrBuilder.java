// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: route_guide.proto

package uk.me.uohiro.grpc.example.model;

public interface RouteNoteOrBuilder extends
    // @@protoc_insertion_point(interface_extends:routeguide.RouteNote)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.routeguide.Point location = 1;</code>
   */
  boolean hasLocation();
  /**
   * <code>.routeguide.Point location = 1;</code>
   */
  uk.me.uohiro.grpc.example.model.Point getLocation();
  /**
   * <code>.routeguide.Point location = 1;</code>
   */
  uk.me.uohiro.grpc.example.model.PointOrBuilder getLocationOrBuilder();

  /**
   * <code>string message = 2;</code>
   */
  java.lang.String getMessage();
  /**
   * <code>string message = 2;</code>
   */
  com.google.protobuf.ByteString
      getMessageBytes();
}
