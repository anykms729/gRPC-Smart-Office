// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: HRDepartmentService.proto

package grpc.services.hr_department_service;

public interface Monthly_Payroll_RequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:office_service.Monthly_Payroll_Request)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int32 normal_working_hour = 1;</code>
   */
  int getNormalWorkingHour();

  /**
   * <code>int32 holiday_pay_working_hour = 2;</code>
   */
  int getHolidayPayWorkingHour();

  /**
   * <code>int32 overtime_working_hour = 3;</code>
   */
  int getOvertimeWorkingHour();
}