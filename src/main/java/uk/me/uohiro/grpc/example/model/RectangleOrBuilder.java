// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: route_guide.proto

package uk.me.uohiro.grpc.example.model;

public interface RectangleOrBuilder extends
    // @@protoc_insertion_point(interface_extends:routeguide.Rectangle)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.routeguide.Point lo = 1;</code>
   */
  boolean hasLo();
  /**
   * <code>.routeguide.Point lo = 1;</code>
   */
  uk.me.uohiro.grpc.example.model.Point getLo();
  /**
   * <code>.routeguide.Point lo = 1;</code>
   */
  uk.me.uohiro.grpc.example.model.PointOrBuilder getLoOrBuilder();

  /**
   * <code>.routeguide.Point hi = 2;</code>
   */
  boolean hasHi();
  /**
   * <code>.routeguide.Point hi = 2;</code>
   */
  uk.me.uohiro.grpc.example.model.Point getHi();
  /**
   * <code>.routeguide.Point hi = 2;</code>
   */
  uk.me.uohiro.grpc.example.model.PointOrBuilder getHiOrBuilder();
}
